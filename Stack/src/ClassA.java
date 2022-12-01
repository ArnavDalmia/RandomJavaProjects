		/* class ClassA 
            this class is used as a way to create a person or actually simply an object that is more comprehendable in comparison to something like a String or int
	 */
    
    public class ClassA {
        /* Field Variables
         * name  : String variable that represnts the name of the individual
         * value : int variable that represents the age of the individual
         */
        private String name;
        private int value;
        /* custructor classA 
                creating a ClassA object requires 2 parameters which define the toString of the object
         * Parameters:
         * 		name  : String variable that represnts the name of the individual
         *      val : int variable that represents the age of the individual
         * Return Value
         * 		none
         * Local Variables:
         * 		none
         */
        public ClassA(String name, int val){
            this.name = name; //sets the field variables to the data from the parameters
            this.value = val;
        }
        /* method getName
         * This method returns the name of the entry
         * Parameters:
         * 		none
         * Return Value
         * 		name  : String variable that represnts the name of the individual
         * Local Variables:
         * 		none
         */
        public String getName(){
            return name; //returns field variable for name
        }
        /* method getValue
         * This method returns the age of entry
         * Parameters:
         * 		none
         * Return Value
         * 		value  : int variable that represnts the age of the individual
         * Local Variables:
         * 		none
         */
        public int getValue(){
            return value;
        }
        /* method setName
         * This method sets the entries name
         * Parameters:
         * 		name  : String variable that represnts the name of the individual
         * Return Value
         * 		none
         * Local Variables:
         * 		none
         */
        public void setName(String name){
            this.name = name; //sets field variable to parameter
        }
          /* method setValue
         * This method sets the entries age
         * Parameters:
         * 		value  : int variable that represnts the age of the individual
         * Return Value
         * 		none
         * Local Variables:
         * 		none
         */
        public void setValue(int value){
            this.value = value;//sets field variable to parameter
        }
        
        /* method toString
         * This method returns a String message that is the toString of each ClassA object
         * Parameters:
         * 		none
         * Return Value
         * 		String variable that is the toString of each ClassA object
         * Local Variables:
         *      none
         */
        
        public String toString(){ 
            return ("Name: "+name+ ", Age: "+value); //returns message
        }
    }
    