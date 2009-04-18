package org.aurifa.demo.strutter.helper;

import net.sf.beanlib.spi.CustomBeanTransformerSpi;
import net.sf.beanlib.spi.BeanTransformerSpi;
import net.sf.beanlib.PropertyInfo;
import net.sf.beanlib.hibernate3.Hibernate3BeanReplicator;
import net.sf.beanlib.hibernate.HibernateBeanReplicator;
import org.hibernate.Hibernate;

/**
 * HibernateLazyKillingReplicator.
 *
 * @author Rene Gielen
 */
public class HibernateLazyKillingReplicator implements Replicator {

    public class LazyNullingBeanTransformer implements CustomBeanTransformerSpi {

        public boolean isTransformable( Object from, Class toClass,
                                        PropertyInfo propertyInfo ) {
            return !Hibernate.isInitialized(from);
        }

        public <T> T transform( Object in, Class<T> toClass,
                                PropertyInfo propertyInfo ) {
            return null;
        }
    }

    public class MyBeanTransformerFactory implements CustomBeanTransformerSpi.Factory {

        public CustomBeanTransformerSpi newCustomBeanTransformer( BeanTransformerSpi beanTransformer ) {
            return new LazyNullingBeanTransformer();
        }
    }

    public <T> T deepCopy( T origin ) {
        HibernateBeanReplicator replicator = new Hibernate3BeanReplicator();
        replicator.initCustomTransformer(new MyBeanTransformerFactory());
        return replicator.deepCopy(origin);
    }

}
