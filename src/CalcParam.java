
public class CalcParam {
	
	/**
	 * 
	 * @hy_value h(a)=a0+a1x1+a2x2+...
	 * @flag ��������
	 * @temp_para �ۻ�ֵ
	 * @min_fun ���ۺ�����Сֵ
	 */
	public static double[] calcByGD(double[][] pred_var, double[] crit_var,double rate) {
		double hy_value;//Ԥ��ֵ
		double cost_fun = 0;//���ۺ���
		int pred_size = pred_var.length - 1;//�Ա�������
		double[] para = new double[pred_size + 1];//�Ա�������h=ax1+bx2+c,para[0]=a,para[1]=b,para[2]=c
		int train_size = pred_var[0].length;//ѵ�����ݸ���

		for(double p : para)
			p = 0;
		
	    for(int i = 0; i < train_size; i++) {
	    	hy_value = 0;
	    	for(int j = 0; j <= pred_size; j++)
	    		hy_value += para[j] * pred_var[j][i];//��Ԥ��ֵ:y = a*x1 + b*x2 + c*x3 + ...
	    	
	    	cost_fun += (hy_value - crit_var[i]) * (hy_value - crit_var[i]);//����ۺ�����ֵ
        }
	    
	    cost_fun /= 2;
	    
	    double min_fun = cost_fun;
		int flag = 0;//��������
			
		while(true) {
			double[] temp_para = new double[pred_size + 1];//���б�ʣ�ƫ������
			for (double d : temp_para)//��ʼ������ֵΪ0
				d = 0;
			
			for(int j = 0; j <= pred_size; j++)		
				for(int i = 0; i < train_size; i++)	{
					hy_value=0;
					for(int h = 0; h <= pred_size; h++)
						hy_value += para[h] * pred_var[h][i];
						
					temp_para[j] += ((hy_value - crit_var[i]) * pred_var[j][i]);//����ۺ�����б��	 
				}
					
			for(int i = 0; i <= pred_size; i++)
				para[i] -= rate * temp_para[i]; //rateѧϰ���ʣ������ݶ��½��Ĳ���
			
	    	for(int i = 0; i < train_size; i++) {
	    		hy_value=0;
			   	for(int j = 0; j <= pred_size; j++)
			   		hy_value += para[j] * pred_var[j][i];
			   	
			   	cost_fun += (hy_value - crit_var[i]) * (hy_value - crit_var[i]);
	        }
	    	
			cost_fun /= 2;
				
			if(cost_fun < min_fun) {
				min_fun = cost_fun;
				flag=0;
			}else
				flag++;
				
			if(flag == 1000)
				break;
		}
		
		System.out.println("cost:" + cost_fun);
		return para;
	}
}
