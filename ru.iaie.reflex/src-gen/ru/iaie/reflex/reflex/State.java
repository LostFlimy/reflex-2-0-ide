/**
 * generated by Xtext 2.29.0
 */
package ru.iaie.reflex.reflex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.reflex.State#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.State#getName <em>Name</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.State#isLooped <em>Looped</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.State#getStateFunction <em>State Function</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.State#getTimeoutFunction <em>Timeout Function</em>}</li>
 * </ul>
 *
 * @see ru.iaie.reflex.reflex.ReflexPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject
{
  /**
   * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
   * The list contents are of type {@link ru.iaie.reflex.reflex.Annotation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotations</em>' containment reference list.
   * @see ru.iaie.reflex.reflex.ReflexPackage#getState_Annotations()
   * @model containment="true"
   * @generated
   */
  EList<Annotation> getAnnotations();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see ru.iaie.reflex.reflex.ReflexPackage#getState_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.reflex.State#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Looped</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Looped</em>' attribute.
   * @see #setLooped(boolean)
   * @see ru.iaie.reflex.reflex.ReflexPackage#getState_Looped()
   * @model
   * @generated
   */
  boolean isLooped();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.reflex.State#isLooped <em>Looped</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Looped</em>' attribute.
   * @see #isLooped()
   * @generated
   */
  void setLooped(boolean value);

  /**
   * Returns the value of the '<em><b>State Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Function</em>' containment reference.
   * @see #setStateFunction(StatementSequence)
   * @see ru.iaie.reflex.reflex.ReflexPackage#getState_StateFunction()
   * @model containment="true"
   * @generated
   */
  StatementSequence getStateFunction();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.reflex.State#getStateFunction <em>State Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State Function</em>' containment reference.
   * @see #getStateFunction()
   * @generated
   */
  void setStateFunction(StatementSequence value);

  /**
   * Returns the value of the '<em><b>Timeout Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timeout Function</em>' containment reference.
   * @see #setTimeoutFunction(TimeoutFunction)
   * @see ru.iaie.reflex.reflex.ReflexPackage#getState_TimeoutFunction()
   * @model containment="true"
   * @generated
   */
  TimeoutFunction getTimeoutFunction();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.reflex.State#getTimeoutFunction <em>Timeout Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timeout Function</em>' containment reference.
   * @see #getTimeoutFunction()
   * @generated
   */
  void setTimeoutFunction(TimeoutFunction value);

} // State
