public class Perceptron {
double weights[];
double sum2;
public double learning_rate=0.1;
public Perceptron(int n){
	weights=new double[n];
	weights[0]=1.83;
	weights[1]=0.5;
	weights[2]=0.2;
}
private double deriveSigm(double s){
	double fact;
	fact=1/(1+Math.exp(-s));
	return (fact)*(1-fact);
}
private double rate(double w,double x,double s,double desired,double predicted){
	double d1,d2,d3;
	d1=predicted-desired;
	System.out.println("d1:"+d1);
	d2=deriveSigm(s);
	System.out.println("d2:"+d2);
	d3=x;
	System.out.println("d3:"+d3);
	System.out.println("----------------------------------------dw:"+d1*d2*d3);
	
	return d1*d2*d3;
	
}
private double sum(double inputs[]){
	double s=0;
	for(int i=0;i<inputs.length;i++){
		s+=inputs[i]*weights[i];
	}
	
	return s;
}
public static double sigmoid(double s){
	return 1/(1+Math.exp(-s));
	
}

private int sign(double s){
	if(s>=0) return 1;
	return -1;
}
public double predict(double inputs[]){
	//sum
	double s=sum(inputs);
	sum2=s;
	System.out.println("sum:"+s);
	//f_activation
	return sigmoid(s);
}

public void trainV2(double inputs[],double desired){
	double error;
	double predictedValue;
	predictedValue=predict(inputs);	
	error=desired-predictedValue;
	double dw;
//	int fact;
	for(int i=0;i<weights.length;i++){
		dw=rate(weights[i], inputs[i], sum2, desired, predictedValue);
			weights[i]-=dw*learning_rate;	
	}
}

public void train(double inputs[],double desired){
	double error;
	double predictedValue;
	predictedValue=predict(inputs);	
	error=desired-predictedValue;
	for(int i=0;i<weights.length;i++)
	weights[i]+=error*inputs[i]*learning_rate;	
}
@Override
	public String toString() {
	String s="";
		for(int i=0;i<weights.length;i++){
			s=s+String.format("%.3f", weights[i])+ "   ";
			//System.out.println(s);
		}
		return s;
	}
public double[] getWeights() {
	return weights;
}
}
