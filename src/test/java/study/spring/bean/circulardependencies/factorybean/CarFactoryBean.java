package study.spring.bean.circulardependencies.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author 王贤
 */
public class CarFactoryBean implements FactoryBean<Car> {
	private String carInfo;

	@Override
	public Car getObject() throws Exception {
		Car car = new Car();
		String [] infos = carInfo.split(",");
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.parseInt(infos[1]));
		car.setPrice(Double.parseDouble(infos[2]));
		return car;
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}
}
