package oleksii.epam.lab.spring2019.core.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("SpecialName")
public class BeanB {
    private final BeanA beanA;

    public BeanB(BeanA beanA) {
        this.beanA = beanA;
    }

    public boolean isBeanAAssigned(){
        return beanA!=null;
    }
}
