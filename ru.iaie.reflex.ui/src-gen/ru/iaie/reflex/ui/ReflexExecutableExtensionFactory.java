/*
 * generated by Xtext 2.29.0
 */
package ru.iaie.reflex.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import ru.iaie.reflex.ui.internal.ReflexActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ReflexExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(ReflexActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		ReflexActivator activator = ReflexActivator.getInstance();
		return activator != null ? activator.getInjector(ReflexActivator.RU_IAIE_REFLEX_REFLEX) : null;
	}

}