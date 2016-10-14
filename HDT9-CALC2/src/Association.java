/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
import java.util.HashMap;
import java.util.Map;

public class Association<K,V> implements Map.Entry<K,V>
{
    /**
     * The immutable key.  An arbitrary object.
     */
    protected K theKey; // the key of the key-value pair
    /**
     * The mutable value.  An arbitrary object.
     */
    protected V theValue; // the value of the key-value pair
    private HashMap<K,V> association;

    /*
      for example:
      Association<String,Integer> personAttribute =
         new Assocation<String,Integer>("Age",34);
     */
    /**
     * Constructs a pair from a key and value.
     *
     * @pre key is non-null
     * @post constructs a key-value pair
     * @param key A non-null object.
     * @param value A (possibly null) object.
     */
    public Association(K key, V value)
    {
        theKey = key;
        theValue = value;
    }

    /**
     * Constructs a pair from a key; value is null.
     *
     * @pre key is non-null
     * @post constructs a key-value pair; value is null
     * @param key A non-null key value.
     */
    public Association(K key)
    {
        this(key,null);
    }

    public Association(){
	association = new HashMap<K,V>();
    }
    
    /**
     * Standard comparison function.  Comparison based on keys only.
     *
     * @pre other is non-null Association
     * @post returns true iff the keys are equal
     * @param other Another association.
     * @return true iff the keys are equal.
     */
    public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey()); //lo importante es que solo compare las llaves 
    }
    
    /**
     * Standard hashcode function.
     *
     * @post return hash code association with this association
     * @return A hash code for association.
     * @see Hashtable
     */
    public int hashCode()
    {
        return getKey().hashCode();
    }
    
    /**
     * Fetch value from association.  May return null.
     *
     * @post returns value from association
     * @return The value field of the association.
     */
    public V getValue()
    {
        return theValue;
    }

    /**
     * Fetch key from association.  Should not return null.
     *
     * @post returns key from association
     * @return Key of the key-value pair.
     */
    public K getKey()
    {
        return theKey;
    }

    /**
     * Sets the value of the key-value pair.
     *
     * @post sets association's value to value
     * @param value The new value.
     */
    public V setValue(V value)
    {
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }
    
    public void put(K key, V value){
            association.put(key, value);
	}
	
	/**
	 * Traduce de ingles a espanol
	 * @param ingles
	 * @return espanol
	 */
	public V get(Object key){
		return association.get(key);
	}

    /**
     * Standard string representation of an association.
     *
     * @post returns string representation
     * @return String representing key-value pair.
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<Association: "+getKey()+"="+getValue()+">");
        return s.toString();
    }
    public String KeyToString(){
        String llave = "";
        llave = ""+getKey();
        return llave;
    } 
}
