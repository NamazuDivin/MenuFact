package code.ingredients;

/**
 * Classe de base de tous les ingrédients
 *
 * @author Domingo
 * @version 1.0
 */
public class Ingredient {
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;

    /**
     * Retourne le nom de l'ingrédient
     *
     * @return le nom de l'ingrédient
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de l'ingrédient
     *
     * @param nom le nouveau nom de l'ingrédient
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la description de l'ingrédient
     *
     * @return la description de l'ingrédient
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifie la description de l'ingrédient
     *
     * @param description la nouvelle description de l'ingrédient
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retourne le type de l'ingrédient
     *
     * @return le type de l'ingrédient
     */
    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    /**
     * Modifie le type de l'ingrédient
     *
     * @param typeIngredient le type de l'ingrédient
     */
    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }
}
