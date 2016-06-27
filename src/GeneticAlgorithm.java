import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang.ArrayUtils;

public class GeneticAlgorithm {
	
	static HashMap<String, Integer> courseStudent;
	
	public static void GA(final Student[] studArr, final Degree[] degArr, final DegreePlan[] degPlanArr, 
			final Section[] sectionArray, String minFillPercent, HashMap<String, Integer> facultyLoad, String maxOverage, String semester) {
		
		Population pop = new Population(studArr, degArr, degPlanArr, sectionArray, minFillPercent, facultyLoad, maxOverage, semester); // No. of nodes are passed to determine the gene length. Adjacency matrix is passed to calculate the fitness function.
        Individual[] newPop = new Individual[Population.POP_SIZE];
        Individual[] indiv = new Individual[2];

        // current population
        System.out.print("Total Fitness = " + pop.totalFitness);
        System.out.println(" ; Best Fitness = "
                + pop.findBestIndividual().getFitnessValue());

        // main loop
        int count;
        for (int iter = 0; iter < Population.MAX_ITER; iter++) {
            count = 0;

            // Elitism
            for (int i = 0; i < Population.ELITISM_K; ++i) {
                newPop[count] = pop.findBestIndividual();
                count++;
            }

            // build new Population
            while (count < Population.POP_SIZE) {
                // Selection
                indiv[0] = pop.rouletteWheelSelection();
                indiv[1] = pop.rouletteWheelSelection();

                // Crossover
                if (Population.m_rand.nextDouble() < Population.CROSSOVER_RATE) {
                    indiv = Population.onePoinCrossover(indiv[0], indiv[1]);
                }

                // Mutation
                if (Population.m_rand.nextDouble() < Population.MUTATION_RATE) {
                    indiv[0].mutate();
                }
                if (Population.m_rand.nextDouble() < Population.MUTATION_RATE) {
                    indiv[1].mutate();
                }

                // add to new population
                newPop[count] = indiv[0];
                newPop[count + 1] = indiv[1];
                count += 2;
            }
            pop.setPopulation(newPop);

            // reevaluate current population
            pop.evaluate(studArr, degArr, degPlanArr, sectionArray, minFillPercent, facultyLoad, maxOverage, semester);
            System.out.print(iter+"\tTotal Fitness = " + pop.totalFitness);
            System.out.println(" ; Best Fitness = "
                    + pop.findBestIndividual().getFitnessValue());
        }

        // best indiv
        Individual bestIndiv = pop.findBestIndividual();
        
        System.out.println("Best Individual Fitness = "
                    + bestIndiv.getFitnessValue());
        
        int[] bestGene = bestIndiv.getGenes();
        GenerateSchedule.secArray = sectionArray;
        
        HashMap<String, Integer> numberOfStudents = numberOfStudents(bestGene, studArr, degArr, degPlanArr, sectionArray, minFillPercent, facultyLoad, maxOverage, semester);
        
        JTable table = new JTable();
		String[] header = new String[3];
		header[0] = "Course";
		header[1] = "Faculty";
		header[2] = "Days";
		
		String[][] obj = new String[sectionArray.length-1][3];
		for(int i=0;i<sectionArray.length-1;i++){
			obj[i][0] = (sectionArray[i].getCourse());
			obj[i][1] = (sectionArray[i+1].getFaculty());
			obj[i][2] = (sectionArray[i+1].getDays());
		}
		
		table.setModel(new DefaultTableModel(obj,header));
		
		GenerateSchedule.setTable(table);
		
        
        System.out.println("\n\nOBTAINED SCHEDULE FOR THE SEMESTER "+semester+" SHALL HAVE FOLLOWING COURSES:");
        for(int i=0;i<bestGene.length;i++){
        	if(bestGene[i]==1){
        		Section sec = sectionArray[i];
        		System.out.println("Course: "+sec.getCourse()+"\tDays: "+sec.getDays()+"\tFaculty: "+sec.getFaculty()+"\tStudents: "+numberOfStudents.get(sec.getCourse()));
        	}
        }
        
        new DisplaySchedule(sectionArray, numberOfStudents).setVisible(true);;
		new DisplaySchedule(sectionArray, numberOfStudents);
		//dispose();
        
        //return sectionArray;
        		
	}
	
	
	public static HashMap<String, Integer> numberOfStudents(int[] genes, Student[] studArr, Degree[] degArr, DegreePlan[] degPlanArr, 
			Section[] secArray, String minFillPercent, HashMap<String, Integer> facultyLoad, String maxOverage, String semester){
        
    	int objectiveValue = 0;
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
    	
    	return courseStudent;
    	
    }

}
