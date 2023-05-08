/**
 * generated by Xtext 2.29.0
 */
package ru.iaie.reflex.reflex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.reflex.Enum#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link ru.iaie.reflex.reflex.Enum#getEnumMembers <em>Enum Members</em>}</li>
 * </ul>
 *
 * @see ru.iaie.reflex.reflex.ReflexPackage#getEnum()
 * @model
 * @generated
 */
public interface Enum extends EObject
{
  /**
   * Returns the value of the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Identifier</em>' attribute.
   * @see #setIdentifier(String)
   * @see ru.iaie.reflex.reflex.ReflexPackage#getEnum_Identifier()
   * @model
   * @generated
   */
  String getIdentifier();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.reflex.Enum#getIdentifier <em>Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Identifier</em>' attribute.
   * @see #getIdentifier()
   * @generated
   */
  void setIdentifier(String value);

  /**
   * Returns the value of the '<em><b>Enum Members</b></em>' containment reference list.
   * The list contents are of type {@link ru.iaie.reflex.reflex.EnumMember}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enum Members</em>' containment reference list.
   * @see ru.iaie.reflex.reflex.ReflexPackage#getEnum_EnumMembers()
   * @model containment="true"
   * @generated
   */
  EList<EnumMember> getEnumMembers();

} // Enum
