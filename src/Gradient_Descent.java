import java.text.DecimalFormat;

public class Gradient_Descent {
	/**
	 * 梯度下降算法
	 * 改程序只能支持一个因变量，多个自变量
	 * @pred_var 自变量
	 * @crit_var 因变量
	 * @para 自变量参数
	 * @rate 学习速率 
	 */
	
	//取一位整数和9位小数，小数位不足用0填充
	static DecimalFormat df   =new DecimalFormat("#.000000000");
	/*
	 * 自变量(多个)
	 * f=ax+b,具有一个自变量，两个参数:a和b. 参数b的值为：{1,1,1,1,...}. 
	 * 因为f=ax+by,y==1
	 */
	static double[][] pred_var;
	//因变量
	static double[] crit_var;
	//学习速率
	static double rate=0.0002;
    
	public static void main(String args[]){
		pred_var=new double[][]{{9,15,25,14,10,18},{1,1,1,1,1,1}};
		crit_var=new double[]{39,56,93,61,50,75};
      
		//计算自变量参数h=ax1+bx2+c,para[0]=a,para[1]=b,para[2]=c
		double[] para = CalcParam.calcByGD(pred_var, crit_var, rate);
		
		for (int i=0;i<pred_var.length;i++) {
			System.out.print("para["+i+"]="+df.format(para[i])+" ");
		}  
	}
}