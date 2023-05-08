/**
 * generated by Xtext 2.29.0
 */
package ru.iaie.reflex.reflex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.reflex.Program#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.Program#getName <em>Name</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.Program#getClock <em>Clock</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.Program#getConsts <em>Consts</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.Program#getEnums <em>Enums</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.Program#getFunctions <em>Functions</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.Program#getGlobalVars <em>Global Vars</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.Program#getPorts <em>Ports</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.Program#getProcesses <em>Processes</em>}</li>
 * </ul>
 *
 * @see ru.iaie.reflex.reflex.ReflexPackage#getProgram()
 * @model
 * @generated
 */
public interface Program extends EObject
{
  /**
   * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
   * The list contents are of type {@link ru.iaie.reflex.reflex.Annotation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotations</em>' containment reference list.
   * @see ru.iaie.reflex.reflex.ReflexPackage#getProgram_Annotations()
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
   * @see ru.iaie.reflex.reflex.ReflexPackage#getProgram_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.reflex.Program#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Clock</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clock</em>' containment reference.
   * @see #setClock(ClockDefinition)
   * @see ru.iaie.reflex.reflex.ReflexPackage#getProgram_Clock()
   * @model containment="true"
   * @generated
   */
  ClockDefinition getClock();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.reflex.Program#getClock <em>Clock</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Clock</em>' containment reference.
   * @see #getClock()
   * @generated
   */
  void setClock(ClockDefinition value);

  /**
   * Returns the value of the '<em><b>Consts</b></em>' containment reference list.
   * The list contents are of type {@link ru.iaie.reflex.reflex.Const}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Consts</em>' containment reference list.
   * @see ru.iaie.reflex.reflex.ReflexPackage#getProgram_Consts()
   * @model containment="true"
   * @generated
   */
  EList<Const> getConsts();

  /**
   * Returns the value of the '<em><b>Enums</b></em>' containment reference list.
   * The list contents are of type {@link ru.iaie.reflex.reflex.Enum}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enums</em>' containment reference list.
   * @see ru.iaie.reflex.reflex.ReflexPackage#getProgram_Enums()
   * @model containment="true"
   * @generated
   */
  EList<ru.iaie.reflex.reflex.Enum> getEnums();

  /**
   * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
   * The list contents are of type {@link ru.iaie.reflex.reflex.Function}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Functions</em>' containment reference list.
   * @see ru.iaie.reflex.reflex.ReflexPackage#getProgram_Functions()
   * @model containment="true"
   * @generated
   */
  EList<Function> getFunctions();

  /**
   * Returns the value of the '<em><b>Global Vars</b></em>' containment reference list.
   * The list contents are of type {@link ru.iaie.reflex.reflex.GlobalVariable}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Global Vars</em>' containment reference list.
   * @see ru.iaie.reflex.reflex.ReflexPackage#getProgram_GlobalVars()
   * @model containment="true"
   * @generated
   */
  EList<GlobalVariable> getGlobalVars();

  /**
   * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
   * The list contents are of type {@link ru.iaie.reflex.reflex.Port}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ports</em>' containment reference list.
   * @see ru.iaie.reflex.reflex.ReflexPackage#getProgram_Ports()
   * @model containment="true"
   * @generated
   */
  EList<Port> getPorts();

  /**
   * Returns the value of the '<em><b>Processes</b></em>' containment reference list.
   * The list contents are of type {@link ru.iaie.reflex.reflex.Process}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Processes</em>' containment reference list.
   * @see ru.iaie.reflex.reflex.ReflexPackage#getProgram_Processes()
   * @model containment="true"
   * @generated
   */
  EList<ru.iaie.reflex.reflex.Process> getProcesses();

} // Program
