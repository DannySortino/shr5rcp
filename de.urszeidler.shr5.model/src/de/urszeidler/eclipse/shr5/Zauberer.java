/**
 */
package de.urszeidler.eclipse.shr5;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Zauberer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.urszeidler.eclipse.shr5.Zauberer#getZauber <em>Zauber</em>}</li>
 *   <li>{@link de.urszeidler.eclipse.shr5.Zauberer#getEnzug <em>Enzug</em>}</li>
 *   <li>{@link de.urszeidler.eclipse.shr5.Zauberer#getTradition <em>Tradition</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.urszeidler.eclipse.shr5.Shr5Package#getZauberer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Zauberer extends EObject {
	/**
     * Returns the value of the '<em><b>Zauber</b></em>' containment reference list.
     * The list contents are of type {@link de.urszeidler.eclipse.shr5.PersonaZauber}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zauber</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Zauber</em>' containment reference list.
     * @see de.urszeidler.eclipse.shr5.Shr5Package#getZauberer_Zauber()
     * @model containment="true"
     * @generated
     */
	EList<PersonaZauber> getZauber();

	/**
     * Returns the value of the '<em><b>Enzug</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enzug</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Enzug</em>' attribute.
     * @see de.urszeidler.eclipse.shr5.Shr5Package#getZauberer_Enzug()
     * @model transient="true" changeable="false" volatile="true"
     * @generated
     */
	int getEnzug();

	/**
     * Returns the value of the '<em><b>Tradition</b></em>' attribute.
     * The literals are from the enumeration {@link de.urszeidler.eclipse.shr5.MagischeTradition}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tradition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Tradition</em>' attribute.
     * @see de.urszeidler.eclipse.shr5.MagischeTradition
     * @see #setTradition(MagischeTradition)
     * @see de.urszeidler.eclipse.shr5.Shr5Package#getZauberer_Tradition()
     * @model
     * @generated
     */
	MagischeTradition getTradition();

	/**
     * Sets the value of the '{@link de.urszeidler.eclipse.shr5.Zauberer#getTradition <em>Tradition</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tradition</em>' attribute.
     * @see de.urszeidler.eclipse.shr5.MagischeTradition
     * @see #getTradition()
     * @generated
     */
	void setTradition(MagischeTradition value);

} // Zauberer
