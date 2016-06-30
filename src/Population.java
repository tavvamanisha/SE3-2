import java.util.HashMap;
import java.util.Random;

public class Population {
	
	public final static int ELITISM_K = 5;
	public final static int POP_SIZE = 100 + ELITISM_K;  // population size
	public static int MAX_ITER = 10;             // max number of iterations
	public final static double MUTATION_RATE = 0.1;     // probability of mutation
	public final static double CROSSOVER_RATE = 0.8;     // probability of crossover

    public static Random m_rand = new Random();  // random-number generator
    private Individual[] m_population;
    public double totalFitness;

    public Population(Student[] studArr, Degree[] degArr, DegreePlan[] degPlanArr, 
			Section[] secArray, String minFillPercent, HashMap<String, Integer> facultyLoad, String maxOverage, String semester, String iterations) {
        m_population = new Individual[POP_SIZE];
        MAX_ITER = Integer.parseInt(iterations);

        // Chromosome Length Calculation:
        // Each node has 2 possibilities. It can either belong to Clusture 0 or Clusture 1.
        // We have used this same property to define the chromosome length. Chromosome length is equals to number of nodes.
        // 1st element of the chromosome corresponds to the Clusture to which the Vertice 1 of the graph belongs to.
        // So, in the optimized condition, vertices will clusture into 2 groups. Hence, the partition will be done.
        for (int i = 0; i < POP_SIZE; i++) {
            m_population[i] = new Individual(secArray);
            m_population[i].randGenes();
        }

        // evaluate current population
        this.evaluate(studArr, degArr, degPlanArr, secArray, minFillPercent, facultyLoad, maxOverage, semester);
    }

    public void setPopulation(Individual[] newPop) {
        System.arraycopy(newPop, 0, this.m_population, 0, POP_SIZE); // Replaces the newPop with the existing population
    }

    public Individual[] getPopulation() {
        return this.m_population;
    }

    public double evaluate(Student[] studArr, Degree[] degArr, DegreePlan[] degPlanArr, 
			Section[] secArray, String minFillPercent, HashMap<String, Integer> facultyLoad, String maxOverage, String semester) {
        this.totalFitness = 0.0;
        for (int i = 0; i < POP_SIZE; i++) {
            this.totalFitness += m_population[i].evaluate(studArr, degArr, degPlanArr, secArray, minFillPercent, facultyLoad, maxOverage, semester);
        }
        return this.totalFitness;
    }

    public Individual rouletteWheelSelection() {
        double randNum = m_rand.nextDouble() * this.totalFitness;
        int idx;
        for (idx=0; idx<POP_SIZE && randNum>0; idx++) {
            randNum -= m_population[idx].getFitnessValue();
        }
        return m_population[idx-1];
    }

    public Individual findBestIndividual() {
        int idxMax = 0, idxMin = 0;
        double currentMax = 0.0;
        double currentMin = 1.0;
        double currentVal;

        for (int idx=0; idx<POP_SIZE; ++idx) {
            currentVal = m_population[idx].getFitnessValue();
            if (currentMax < currentMin) {
                currentMax = currentMin = currentVal;
                idxMax = idxMin = idx;
            }
            if (currentVal > currentMax) {
                currentMax = currentVal;
                idxMax = idx;
            }
            if (currentVal < currentMin) {
                currentMin = currentVal;
                idxMin = idx;
            }
        }

        //return m_population[idxMin];      // minimization
        return m_population[idxMax];        // maximization
    }

    
    public static Individual[] onePoinCrossover(Individual indiv1,Individual indiv2) {
        Individual[] newIndiv = new Individual[2];
        newIndiv[0] = new Individual();
        newIndiv[1] = new Individual();

        int randPoint = m_rand.nextInt(Individual.SIZE);
        int i;
        for (i=0; i<randPoint; ++i) {
            newIndiv[0].setGene(i, indiv1.getGene(i));
            newIndiv[1].setGene(i, indiv2.getGene(i));
        }
        for (; i<Individual.SIZE; ++i) {
            newIndiv[0].setGene(i, indiv2.getGene(i));
            newIndiv[1].setGene(i, indiv1.getGene(i));
        }
        return newIndiv;
    }
    
    
    public static Individual[] uniformCrossover(Individual indiv1,Individual indiv2){
    	Individual[] newIndiv = new Individual[2];
        newIndiv[0] = new Individual();
        newIndiv[1] = new Individual();
        
        for(int i = 0; i< Individual.SIZE; i++){
        	 if(Math.random() > 0.5)
             	newIndiv[0].setGene(i, indiv1.getGene(i));             
        	 else
        		 newIndiv[0].setGene(i, indiv2.getGene(i));
        	 if(Math.random() > 0.5)
              	newIndiv[1].setGene(i, indiv1.getGene(i));             
         	 else
         		 newIndiv[1].setGene(i, indiv2.getGene(i));
        }        
        return newIndiv;        
    }
	
}
