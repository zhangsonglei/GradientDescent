
public class CalcParam {
	
	/**
	 * 
	 * @hy_value h(a)=a0+a1x1+a2x2+...
	 * @flag 迭代次数
	 * @temp_para 累积值
	 * @min_fun 代价函数最小值
	 */
	public static double[] calcByGD(double[][] pred_var, double[] crit_var,double rate) {
		double hy_value;//预测值
		double cost_fun = 0;//代价函数
		int pred_size = pred_var.length - 1;//自变量个数
		double[] para = new double[pred_size + 1];//自变量参数h=ax1+bx2+c,para[0]=a,para[1]=b,para[2]=c
		int train_size = pred_var[0].length;//训练数据个数

		for(double p : para)
			p = 0;
		
	    for(int i = 0; i < train_size; i++) {
	    	hy_value = 0;
	    	for(int j = 0; j <= pred_size; j++)
	    		hy_value += para[j] * pred_var[j][i];//求预测值:y = a*x1 + b*x2 + c*x3 + ...
	    	
	    	cost_fun += (hy_value - crit_var[i]) * (hy_value - crit_var[i]);//求代价函数的值
        }
	    
	    cost_fun /= 2;
	    
	    double min_fun = cost_fun;
		int flag = 0;//迭代次数
			
		while(true) {
			double[] temp_para = new double[pred_size + 1];//存放斜率（偏导数）
			for (double d : temp_para)//初始化参数值为0
				d = 0;
			
			for(int j = 0; j <= pred_size; j++)		
				for(int i = 0; i < train_size; i++)	{
					hy_value=0;
					for(int h = 0; h <= pred_size; h++)
						hy_value += para[h] * pred_var[h][i];
						
					temp_para[j] += ((hy_value - crit_var[i]) * pred_var[j][i]);//求代价函数的斜率	 
				}
					
			for(int i = 0; i <= pred_size; i++)
				para[i] -= rate * temp_para[i]; //rate学习速率，代表梯度下降的步长
			
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
