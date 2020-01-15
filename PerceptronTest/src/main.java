
public class main{
	public static void main(String[] args) {
	
	double inputs[]=new double[3];
	double predictedValue;
	double error;
	inputs[0]=1;
	inputs[1]=0.1;
	inputs[2]=0.3;
	double output=0.03;
	double weights[];
	Perceptron brain=new Perceptron(3);
	
	for(int i=0;i<10000;i++){
		System.out.println("Step "+ (i+1)+": ------------------------------------ ");
	 predictedValue=brain.predict(inputs);
	System.out.println("predication: "+predictedValue);
	error=0.5*Math.pow(output-predictedValue, 2);
	System.out.println("Loss-quadr: "+error);
	
	brain.train(inputs, output);
	brain.trainV2(inputs, output);
	
	weights=brain.getWeights();
	System.out.println(brain);
	System.out.println("-------------------------------------------------");
	}
	
		
	}
}
