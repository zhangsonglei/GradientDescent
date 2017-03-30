import java.text.DecimalFormat;

public class Gradient_Descent {
	/**
	 * �ݶ��½��㷨
	 * �ĳ���ֻ��֧��һ�������������Ա���
	 * @pred_var �Ա���
	 * @crit_var �����
	 * @para �Ա�������
	 * @rate ѧϰ���� 
	 */
	
	//ȡһλ������9λС����С��λ������0���
	static DecimalFormat df   =new DecimalFormat("#.000000000");
	/*
	 * �Ա���(���)
	 * f=ax+b,����һ���Ա�������������:a��b. ����b��ֵΪ��{1,1,1,1,...}. 
	 * ��Ϊf=ax+by,y==1
	 */
	static double[][] pred_var;
	//�����
	static double[] crit_var;
	//ѧϰ����
	static double rate=0.0002;
    
	public static void main(String args[]){
		pred_var=new double[][]{{9,15,25,14,10,18},{1,1,1,1,1,1}};
		crit_var=new double[]{39,56,93,61,50,75};
      
		//�����Ա�������h=ax1+bx2+c,para[0]=a,para[1]=b,para[2]=c
		double[] para = CalcParam.calcByGD(pred_var, crit_var, rate);
		
		for (int i=0;i<pred_var.length;i++) {
			System.out.print("para["+i+"]="+df.format(para[i])+" ");
		}  
	}
}