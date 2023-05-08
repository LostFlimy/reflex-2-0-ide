/*
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.ui.labeling;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;

/**
 * Provides labels for IEObjectDescriptions and IResourceDescriptions.
 * 
 * https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
 */
public class ReflexDescriptionLabelProvider extends DefaultDescriptionLabelProvider {

	// Labels and icons can be computed like this:
	
	public String text(IEObjectDescription obj) {
		return obj.getEClass().getName();
	}
//	 
//	String image(IEObjectDescription ele) {
//		return ele.getEClass().getName() + ".gif";
//	}
}