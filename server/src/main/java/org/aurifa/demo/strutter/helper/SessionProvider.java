package org.aurifa.demo.strutter.helper;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * The SessionProvider abstracts the Hibernate SessionFactory and Session creation configuration aspects.
 *
 */
public class SessionProvider extends HibernateDaoSupport {

    private boolean allowCreateNew = true;

    protected void initDao() throws Exception {
        super.initDao();
        getHibernateTemplate().setFlushMode(HibernateTemplate.FLUSH_AUTO);
    }

    public void setAllowCreateNew( boolean allowCreateNew ) {
        this.allowCreateNew = allowCreateNew;
    }

    public boolean isAllowCreateNew() {
        return allowCreateNew;
    }

    public Session getCurrentSession( boolean allowCreateNew ) {
        return getSession(allowCreateNew);
    }

    public Session getCurrentSession() {
        return getCurrentSession(isAllowCreateNew());
    }

}
