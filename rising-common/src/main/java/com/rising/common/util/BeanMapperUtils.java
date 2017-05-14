package com.rising.common.util;

import java.lang.reflect.InvocationTargetException;

import ma.glasnost.orika.CustomFilter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;

import org.apache.commons.lang.StringUtils;


/**
 * BEAN映射拷贝工具
 * 
 * @author zhurz
 */
public class BeanMapperUtils {

	private static MapperFacade mapper;// 映射
    static {
        CustomFilter<Object, Object> filter = new CustomFilter<Object, Object>() {
            public <S, D> boolean shouldMap(Type<S> sourceType,
                                            String sourceName, S source, Type<D> destType,
                                            String destName, D dest, MappingContext mappingContext) {
                return true;
            }

            public boolean filtersSource() {
                return false;
            }

            public boolean filtersDestination() {
                return true;
            }

            public <S> S filterSource(S sourceValue, Type<S> sourceType,
                                      String sourceName, Type<?> destType, String destName,
                                      MappingContext mappingContext) {
                return sourceValue;
            }

            public <D> D filterDestination(D destinationValue,
                                           Type<?> sourceType, String sourceName, Type<D> destType,
                                           String destName, MappingContext mappingContext) {
                return destinationValue;
            }
        };

        DefaultMapperFactory factory = new DefaultMapperFactory.Builder()
                .build();
        mapper = factory.getMapperFacade();
    }
	/**
	 * 映射BEAN，并拷贝
	 * 
	 * @param sourceObject
	 * @param destinationClass
	 * @return
	 */
	public static <T> T map(Object sourceObject, Class<T> destinationClass) {
		if (sourceObject == null || destinationClass == null)
			return null;
		return mapper.map(sourceObject, destinationClass);

	}

	public static <T> T map(Object sourceObject, Class<T> destinationClass,
			String... customProperties) throws IllegalArgumentException,
			SecurityException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		if (sourceObject == null || destinationClass == null)
			return null;
		T t = mapper.map(sourceObject, destinationClass);
		if (customProperties != null) {
			for (String prop : customProperties) {
				String[] propArr = StringUtils.split(prop, ":");
				MyBeanUtils.setSimpleProperty(t, propArr[1], MyBeanUtils.getSimpleProperty(sourceObject, propArr[0]));
			}
		}

		return t;
	}

	public static MapperFacade getMapper() {
		return mapper;
	}

	public static void main(String[] args) throws IllegalArgumentException,
			SecurityException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		
	}
}