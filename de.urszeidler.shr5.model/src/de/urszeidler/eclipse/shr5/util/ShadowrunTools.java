/**
 * 
 */
package de.urszeidler.eclipse.shr5.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.urszeidler.eclipse.shr5.AbstraktPersona;
import de.urszeidler.eclipse.shr5.Fertigkeit;
import de.urszeidler.eclipse.shr5.FertigkeitsGruppe;
import de.urszeidler.eclipse.shr5.GeldWert;
import de.urszeidler.eclipse.shr5.PersonaFertigkeit;
import de.urszeidler.eclipse.shr5.PersonaFertigkeitsGruppe;
import de.urszeidler.eclipse.shr5.Shr5Factory;
import de.urszeidler.eclipse.shr5.Shr5Package;
import de.urszeidler.eclipse.shr5.Spezies;

/**
 * Collection of tool methods.
 * 
 * @author urs
 */
public class ShadowrunTools {

    private static Map<EAttribute, EAttribute> base2SpeciesMin;
    private static Map<EAttribute, EAttribute> base2SpeciesMax;
    private static Map<EAttribute, EAttribute> base2Calced;

    static {
        base2SpeciesMin = new HashMap<EAttribute, EAttribute>();
        base2SpeciesMin.put(Shr5Package.Literals.ABSTRAKT_PERSONA__KONSTITUTION_BASIS, Shr5Package.Literals.SPEZIES__KONSTITUTION_MIN);
        base2SpeciesMin.put(Shr5Package.Literals.ABSTRAKT_PERSONA__GESCHICKLICHKEIT_BASIS, Shr5Package.Literals.SPEZIES__GESCHICKLICHKEIT_MIN);
        base2SpeciesMin.put(Shr5Package.Literals.ABSTRAKT_PERSONA__REAKTION_BASIS, Shr5Package.Literals.SPEZIES__REAKTION_MIN);
        base2SpeciesMin.put(Shr5Package.Literals.ABSTRAKT_PERSONA__STAERKE_BASIS, Shr5Package.Literals.SPEZIES__STAERKE_MIN);
        base2SpeciesMin.put(Shr5Package.Literals.ABSTRAKT_PERSONA__CHARISMA_BASIS, Shr5Package.Literals.SPEZIES__CHARISMA_MIN);
        base2SpeciesMin.put(Shr5Package.Literals.ABSTRAKT_PERSONA__INTUITION_BASIS, Shr5Package.Literals.SPEZIES__INTUITION_MIN);
        base2SpeciesMin.put(Shr5Package.Literals.ABSTRAKT_PERSONA__LOGIK_BASIS, Shr5Package.Literals.SPEZIES__LOGIK_MIN);
        base2SpeciesMin.put(Shr5Package.Literals.ABSTRAKT_PERSONA__WILLENSKRAFT_BASIS, Shr5Package.Literals.SPEZIES__WILLENSKRAFT_MIN);
        base2SpeciesMin.put(Shr5Package.Literals.BASE_MAGISCHE_PERSONA__MAGIE_BASIS, Shr5Package.Literals.SPEZIES__MAGIE_MIN);
        base2SpeciesMin.put(Shr5Package.Literals.RESONANZ_PERSONA__RESONANZ_BASIS, Shr5Package.Literals.SPEZIES__RESONANZ_MIN);

        base2SpeciesMax = new HashMap<EAttribute, EAttribute>();
        base2SpeciesMax.put(Shr5Package.Literals.ABSTRAKT_PERSONA__KONSTITUTION_BASIS, Shr5Package.Literals.SPEZIES__KONSTITUTION_MAX);
        base2SpeciesMax.put(Shr5Package.Literals.ABSTRAKT_PERSONA__GESCHICKLICHKEIT_BASIS, Shr5Package.Literals.SPEZIES__GESCHICKLICHKEIT_MAX);
        base2SpeciesMax.put(Shr5Package.Literals.ABSTRAKT_PERSONA__REAKTION_BASIS, Shr5Package.Literals.SPEZIES__REAKTION_MAX);
        base2SpeciesMax.put(Shr5Package.Literals.ABSTRAKT_PERSONA__STAERKE_BASIS, Shr5Package.Literals.SPEZIES__STAERKE_MAX);
        base2SpeciesMax.put(Shr5Package.Literals.ABSTRAKT_PERSONA__CHARISMA_BASIS, Shr5Package.Literals.SPEZIES__CHARISMA_MAX);
        base2SpeciesMax.put(Shr5Package.Literals.ABSTRAKT_PERSONA__INTUITION_BASIS, Shr5Package.Literals.SPEZIES__INTUITION_MAX);
        base2SpeciesMax.put(Shr5Package.Literals.ABSTRAKT_PERSONA__LOGIK_BASIS, Shr5Package.Literals.SPEZIES__LOGIK_MAX);
        base2SpeciesMax.put(Shr5Package.Literals.ABSTRAKT_PERSONA__WILLENSKRAFT_BASIS, Shr5Package.Literals.SPEZIES__WILLENSKRAFT_MAX);
        base2SpeciesMax.put(Shr5Package.Literals.BASE_MAGISCHE_PERSONA__MAGIE_BASIS, Shr5Package.Literals.SPEZIES__MAGIE_MAX);
        base2SpeciesMax.put(Shr5Package.Literals.RESONANZ_PERSONA__RESONANZ_BASIS, Shr5Package.Literals.SPEZIES__RESONANZ_MAX);

        base2Calced = new HashMap<EAttribute, EAttribute>();
        base2Calced.put(Shr5Package.Literals.ABSTRAKT_PERSONA__KONSTITUTION_BASIS, Shr5Package.Literals.KOERPERLICHE_ATTRIBUTE__KONSTITUTION);
        base2Calced.put(Shr5Package.Literals.ABSTRAKT_PERSONA__GESCHICKLICHKEIT_BASIS, Shr5Package.Literals.KOERPERLICHE_ATTRIBUTE__GESCHICKLICHKEIT);
        base2Calced.put(Shr5Package.Literals.ABSTRAKT_PERSONA__REAKTION_BASIS, Shr5Package.Literals.KOERPERLICHE_ATTRIBUTE__REAKTION);
        base2Calced.put(Shr5Package.Literals.ABSTRAKT_PERSONA__STAERKE_BASIS, Shr5Package.Literals.KOERPERLICHE_ATTRIBUTE__STAERKE);
        base2Calced.put(Shr5Package.Literals.ABSTRAKT_PERSONA__CHARISMA_BASIS, Shr5Package.Literals.GEISTIGE_ATTRIBUTE__CHARISMA);
        base2Calced.put(Shr5Package.Literals.ABSTRAKT_PERSONA__INTUITION_BASIS, Shr5Package.Literals.GEISTIGE_ATTRIBUTE__INTUITION);
        base2Calced.put(Shr5Package.Literals.ABSTRAKT_PERSONA__LOGIK_BASIS, Shr5Package.Literals.GEISTIGE_ATTRIBUTE__LOGIK);
        base2Calced.put(Shr5Package.Literals.ABSTRAKT_PERSONA__WILLENSKRAFT_BASIS, Shr5Package.Literals.GEISTIGE_ATTRIBUTE__WILLENSKRAFT);
        base2Calced.put(Shr5Package.Literals.BASE_MAGISCHE_PERSONA__MAGIE_BASIS, Shr5Package.Literals.BASE_MAGISCHE_PERSONA__MAGIE);
        base2Calced.put(Shr5Package.Literals.RESONANZ_PERSONA__RESONANZ_BASIS, Shr5Package.Literals.RESONANZ_PERSONA__RESONANZ);

    }

    /**
     * Get the species min attribute for a persona attribute.
     * 
     * @param attribute
     * @return
     */
    public static EAttribute base2Calced(EAttribute attribute) {
        return base2Calced.get(attribute);
    }
    /**
     * Get the species min attribute for a persona attribute.
     * 
     * @param attribute
     * @return
     */
    public static EAttribute base2SpeciesMin(EAttribute attribute) {
        return base2SpeciesMin.get(attribute);
    }
    /**
     * Get the species max attribute for a persona attribute.
     * 
     * @param attribute
     * @return
     */
    public static EAttribute base2SpeciesMax(EAttribute attribute) {
        return base2SpeciesMax.get(attribute);
    }

    /**
     * Creates and initalise a character with the given spezies.
     * 
     * @param spezies
     * @param eclass
     * @param edge
     * @return
     */
    public static AbstraktPersona createPersona(Spezies spezies, EClass eclass, int edge) {
        EObject p = Shr5Factory.eINSTANCE.create(eclass);

        AbstraktPersona persona = (AbstraktPersona)p;
        persona.setSpezies(spezies);
        persona.setKonstitutionBasis(spezies.getKonstitutionMin());
        persona.setGeschicklichkeitBasis(spezies.getGeschicklichkeitMin());
        persona.setReaktionBasis(spezies.getReaktionMin());
        persona.setStaerkeBasis(spezies.getStaerkeMin());

        persona.setCharismaBasis(spezies.getCharismaMin());
        persona.setIntuitionBasis(spezies.getIntuitionMin());
        persona.setLogikBasis(spezies.getLogikMin());
        persona.setWillenskraftBasis(spezies.getWillenskraftMin());

        persona.setEdgeBasis(spezies.getEdgeMin());
        // persona.setEdgeBasis(edge);

        return persona;
    }

    /**
     * Returns the geldwert as rounded string.
     * 
     * @param list
     * @return
     */
    public static String calcListenWertToString(EList<Object> list) {
        BigDecimal summ = calcListenWert(list);
        return summ.longValue() + "";
    }

    /**
     * Calcs the wert of all {@link GeldWert} in the given list.
     * 
     * @param list
     * @return
     */
    public static BigDecimal calcListenWert(List<? extends Object> list) {
        BigDecimal summ = new BigDecimal(0);
        for (Object eo : list) {
            if (eo instanceof GeldWert) {
                GeldWert wert = (GeldWert)eo;

                if (wert.getWert() != null)
                    summ = summ.add(wert.getWert());
            }
        }
        return summ;
    }

    /**
     * Find the value of the personafertigeitsgruppe for a persona.
     * 
     * @param fg the {@link FertigkeitsGruppe} to look for
     * @param persona the persona
     * @return the value or 0
     */
    public static int findFertigkeitValue(FertigkeitsGruppe fg, AbstraktPersona persona) {
        PersonaFertigkeitsGruppe pfg = findGruppe(fg, persona);
        if (pfg != null)
            return pfg.getStufe();

        return 0;
    }

    /**
     * Finds the values of {@link PersonaFertigkeitsGruppe} for a given {@link FertigkeitsGruppe} and persona.
     * 
     * @param fg the fertigkeit
     * @param persona the persina
     * @return null or the {@link PersonaFertigkeitsGruppe}r
     */
    public static PersonaFertigkeitsGruppe findGruppe(FertigkeitsGruppe fg, AbstraktPersona persona) {
        EList<PersonaFertigkeitsGruppe> fertigkeitsGruppen = persona.getFertigkeitsGruppen();
        for (PersonaFertigkeitsGruppe personaFertigkeitsGruppe : fertigkeitsGruppen) {
            if (fg.equals(personaFertigkeitsGruppe.getGruppe()))
                return personaFertigkeitsGruppe;
        }
        return null;
    }

    /**
     * Returns the stufe or -1.
     * 
     * @param fertigkeit
     * @param persona
     * @return
     */
    public static Integer findFertigkeitValue(Fertigkeit fertigkeit, AbstraktPersona persona) {
        PersonaFertigkeit pf = findFertigkeit(fertigkeit, persona);
        if (pf != null)
            if (pf.getStufe() == 0)
                return -1;
            else
                return pf.getStufe();

        if (Shr5Package.Literals.FERTIGKEITS_GRUPPE__FERTIGKEITEN.equals(fertigkeit.eContainmentFeature())) {
            FertigkeitsGruppe eContainer = (FertigkeitsGruppe)fertigkeit.eContainer();
            PersonaFertigkeitsGruppe gruppe = findGruppe(eContainer, persona);
            if (gruppe != null)
                return gruppe.getStufe();
        }

        return -1;
    }

    /**
     * Returns the persona fertigkeit or null.
     * 
     * @param fertigkeit
     * @param persona
     * @return
     */
    public static PersonaFertigkeit findFertigkeit(Fertigkeit fertigkeit, AbstraktPersona persona) {
        EList<PersonaFertigkeit> fertigkeiten = persona.getFertigkeiten();
        for (PersonaFertigkeit personaFertigkeit : fertigkeiten) {
            if (fertigkeit.equals(personaFertigkeit.getFertigkeit()))
                return personaFertigkeit;
        }
        return null;
    }

    /**
     * Calcs the race maximum for the given persona and the max feature.
     * 
     * @param persona
     * @param attribute
     * @return
     */
    public static int calcRaceMaximum(AbstraktPersona persona, EAttribute attribute) {
        if (persona == null)
            return -1;

        Spezies spezies = persona.getSpezies();
        if (spezies == null)
            return -1;

        int value = (Integer)spezies.eGet(attribute);
        int wert = persona.getModManager().getmodWert(attribute);
        int halfEven = (int)Math.ceil((float)(value + wert) / 2F);

        return value + halfEven;
    }

    public static boolean hasFertigkeitUnderGroup(FertigkeitsGruppe fg, AbstraktPersona persona) {
        EList<Fertigkeit> fertigkeiten = fg.getFertigkeiten();
        for (Fertigkeit fertigkeit : fertigkeiten) {
            if (findFertigkeit(fertigkeit, persona) != null)
                return true;
        }
        return false;
    }

    /**
     * calcs a simple Karma costs.
     * 
     * @param from
     * @param to
     * @param fac
     * @return
     */
    public static int calcKarmaCosts(int from, int to, int fac) {
        if (from < 0 || to <= 0)
            return 0;

        if (from >= to)
            return 0;

        int sum = 0;
        for (int i = from; i < to; i++) {
            sum += (i + 1) * fac;
        }
        return (int)sum;
    }

}
