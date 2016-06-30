import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;

public class Individual {
	
	public static int SIZE = 10000;
    private int[] genes = new int[SIZE];
    private double fitnessValue;
    private HashMap<String, Integer> numberOfStudent;
    
    
	public HashMap<String, Integer> getNumberOfStudent() {
		return numberOfStudent;
	}

	public void setNumberOfStudent(HashMap<String, Integer> numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}

	public int[] getGenes() {
		return genes;
	}

	public void setGenes(int[] genes) {
		this.genes = genes;
	}

	public Individual(Section[] secArray) {
        Individual.SIZE = secArray.length;
        this.setSIZE(secArray.length);
    }
    
    public Individual() {}
    
    public static int getSIZE() {
        return SIZE;
    }

    public static void setSIZE(int SIZE) {
        Individual.SIZE = SIZE;
    }
    
    public double getFitnessValue() {
        return fitnessValue;
    }

    public void setFitnessValue(double fitnessValue) {
        this.fitnessValue = fitnessValue;
    }

    public int getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, int gene) {
        this.genes[index] = gene;
    }

    public void randGenes() {
        Random rand = new Random();
        for(int i=0; i<SIZE; ++i) {
            this.setGene(i, rand.nextInt(2));
        }
    }

    public void mutate() {
        Random rand = new Random();
        int index = rand.nextInt(SIZE);
        this.setGene(index, 1-this.getGene(index));    // flip
    }

    public double evaluate(Student[] studArr, Degree[] degArr, DegreePlan[] degPlanArr, 
			Section[] secArray, String minFillPercent, HashMap<String, Integer> facultyLoad, String maxOverage, String semester) {
        this.setFitnessValue(objectiveFunction(this.genes, studArr, degArr, degPlanArr, secArray, minFillPercent, facultyLoad, maxOverage, semester));
        return this.fitnessValue;
    }
    
    public double objectiveFunction(int[] genes, Student[] studArr, Degree[] degArr, DegreePlan[] degPlanArr, 
			Section[] secArray, String minFillPercent, HashMap<String, Integer> facultyLoad, String maxOverage, String semester){
        
    	int objectiveValue = 0;
    	int facultyLoadExceedPenalty = 0;
    	int numberOfCoursesPenalty = 0;
    	int maxStudentCountPenalty = 0;
    	HashMap<String, Integer> courseStudent = new HashMap();
    	
    	//Possible genes[] array will be like:
    	// [1 0 0 1 0 0 0 1 1 1 0 1 1 1 0 0 1 0 0 0 1 1 1 0 1 1 1 0 0 1 0 0 0 1 1 1 0 1 1 1 0 0 1 0 0 0 1]
    	// Section Array will be like:
    	// [SEC1 SEC2 SEC3..............................................................................SEC47]
    	// Get the degree to which the student is enrolled to.
    	for(int i=0;i<studArr.length;i++){ // Looping the code for each student.
    		Student student = studArr[i];
    		String degreeCode = student.getDegree(); // Getting the Degree to which student is enrolled to.
    		String[] coursesApplied = student.getCourseNum(); // Getting the course list to which the student has already applied to.
    		String[] gradesReceived = student.getGrade(); // Getting the grades of the courses to which the student had applied.
    		
    		DegreePlan degreePlan = new DegreePlan(); // 
    		for(int j=0;j<degPlanArr.length;j++){
    			if(degPlanArr[j].getDegreeCode().equalsIgnoreCase(degreeCode)){ // Checking which degree plan student belongs to
    				degreePlan = degPlanArr[j];
    				String[] coursesToApplyStandard = degreePlan.getCourses().replaceAll("^\"|\"$", "").split(","); // Standard List of Courses which the student needs to Pass.
    				String[] coursesToApplyStud = coursesToApplyStandard; // List of Courses which the Student needs to complete now after passing some Courses.
    				int creditsToEarn = Integer.parseInt(degreePlan.getHours()); // More credits to be earn to pass the degree plan.
    				
    				if(coursesApplied != null){
    					for(int k=0;k<coursesApplied.length;k++){ // Looping to the course list which Student has already applied.
        					for(int l=0;l<coursesToApplyStandard.length;l++){ // Looping through the standard Courses list.
        						if(coursesApplied[k].equals(coursesToApplyStandard[l])){ // If the student has applied for this coarse earlier.
        							if(creditsToEarn > 0){ // If the student needs to earn more Credits.
        								if("A".equalsIgnoreCase(gradesReceived[k])
        										|| "B".equalsIgnoreCase(gradesReceived[k])
        										|| "C".equalsIgnoreCase(gradesReceived[k])
        										|| "D".equalsIgnoreCase(gradesReceived[k])
        										|| "CIP".equalsIgnoreCase(gradesReceived[k])){
        									// If the student has passed the course remove it from the coursesToApplyStud Array
        									// And update the creditToEarn.
        									ArrayUtils.removeElement(coursesToApplyStud, coursesToApplyStandard[l]);
        									creditsToEarn = creditsToEarn - 3;
        								}
        							} else { // If the student has earned all the credits required for the degree plan.
        								coursesToApplyStud = new String[0];
        							}
        						}
        					}
        				}
    				}
    				
    				// Now the courseToApplyStud has the list of courses which the student needs to apply.
    				// And the creditsToEarn has the value of credits which the student has to earn.
    				
    				for(int m=0;m<genes.length;m++){ // Looping through the gene value
    					if(genes[m] == 1){ // If the section was selected in the schedule
    						Section section = secArray[m];
    						if(ArrayUtils.contains(coursesToApplyStud, section.getCourse())){ // If the student has to apply for the course which is available in the schedule.
    							objectiveValue++;
    							if(courseStudent.containsKey(section.getCourse())){
    								int number = courseStudent.get(section.getCourse());
    								courseStudent.put(section.getCourse(), number+1);
    							}else{
    								courseStudent.put(section.getCourse(), 1);
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	// Now for the students who are newly expected to be joining the university.
    	for(int i=1;i<degArr.length;i++){
    		
    		String degreeCode = degArr[i].getDegreeCode();
    		int numberOfStudents = Integer.parseInt(degArr[i].getForecast());
    		
    		DegreePlan degreePlan = new DegreePlan();
    		for(int j=0;j<degPlanArr.length;j++){
    			if(degPlanArr[j].getDegreeCode().equalsIgnoreCase(degreeCode)){ // Checking which degree plan student belongs to
    				degreePlan = degPlanArr[j];
    				String[] coursesToApplyStud  = degreePlan.getCourses().replaceAll("^\"|\"$", "").split(","); // Standard List of Courses which the student needs to Pass.
    				//int creditsToEarn = Integer.parseInt(degreePlan.getHours()); // More credits to be earn to pass the degree plan.
    				
    				// Now the courseToApplyStud has the list of courses which the student needs to apply.
    				// And the creditsToEarn has the value of credits which the student has to earn.
    				
    				for(int m=0;m<genes.length;m++){ // Looping through the gene value
    					if(genes[m] == 1){ // If the section was selected in the schedule
    						Section section = secArray[m];
    						if(ArrayUtils.contains(coursesToApplyStud, section.getCourse())){
    							objectiveValue = objectiveValue+numberOfStudents;
    							if(courseStudent.containsKey(section.getCourse())){
    								int number = courseStudent.get(section.getCourse());
    								courseStudent.put(section.getCourse(), number+numberOfStudents);
    							}else{
    								courseStudent.put(section.getCourse(), numberOfStudents);
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	// Now adding a penalty factor for each of the course.
    	/*
    	
    	System.out.println("\n");
    	for(int i=0;i<genes.length;i++){
    		System.out.print(genes[i]+",");
    	}
    	System.out.println("\n");
    	
    	
    	Set SOK1 = courseStudent.keySet();
		Iterator iterator1 = SOK1.iterator();
		while(iterator1.hasNext()){
			String course = (String) iterator1.next();
			int cnt = (int) courseStudent.get(course);
			System.out.print(cnt+",");
		}*/
    	
    	int count = 0;
    	for(int i=0;i<genes.length;i++){
    		if(genes[i]==1)count++;
    	}
    	numberOfCoursesPenalty = count * ((Integer.parseInt(minFillPercent)*25)/100);
    	
    	// Now adding penalty for unsatisfied Faculty.
    	Set SOK = facultyLoad.keySet();
		Iterator iterator = SOK.iterator();
		while(iterator.hasNext()){
			String fac = (String) iterator.next();
			int maxLoad = (int) facultyLoad.get(fac);
			int load = 0;
			
			for(int j=0;j<genes.length;j++){
    			if(genes[j]==1){
    				Section sec = secArray[j];
    				if(fac.equalsIgnoreCase(sec.getFaculty())){
    					load = load+3;
    				}
    					
    			}
    		}
    		
    		if(load>maxLoad){
    			//System.out.println(facultyLoadExceedPenalty);
    			facultyLoadExceedPenalty = facultyLoadExceedPenalty + 10000000;
    		}
		}
		
    	
    	/*for(int i=1;i<facArr.length;i++){
    		Faculty fac = facArr[i];
    		int load = 0;
    		System.out.println(facultyLoad);
    		System.out.println(facultyLoad.size());
    		System.out.println(fac.getLastname());
    		int maxLoad = facultyLoad.get(fac.getLastname());
    		
    	}*/
		
		Set SOK1 = courseStudent.keySet();
		Iterator iterator1 = SOK1.iterator();
		while(iterator1.hasNext()){
			String course = (String) iterator1.next();
			int cnt = (int) courseStudent.get(course);

			if(cnt>25*(1+(Integer.parseInt(maxOverage)/100))){
				maxStudentCountPenalty = cnt * 10;
			}
		}
		
    	int fitness = (objectiveValue - numberOfCoursesPenalty - facultyLoadExceedPenalty-maxStudentCountPenalty);
    	
    	if(fitness<0)return 0;
    	else return fitness;
    }
    
}
