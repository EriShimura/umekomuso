package dao;

import javax.jdo.*;

/////////////////////////////////////////////
// factoryをあらかじめ作って保持してくれるクラス
/////////////////////////////////////////////

public class PMF {
	private static final PersistenceManagerFactory factory = 
			JDOHelper.getPersistenceManagerFactory("transactions-optional");
	private PMF(){}
	public static PersistenceManagerFactory get(){ return factory; }
}
