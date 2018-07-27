/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Budiarti
 */
public class Country {
    private String countryId;
    private String countryName;
    private int regionId;

    public Country() {
    }

    public Country(String countryId, String countryName, int regionId) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.regionId = regionId;
    }

    
    /**
     * @return the countryId mengambil nilai dari county_id
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * @param countryId the countryId to set memberikan/memasukkan nilai ke country_id
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    /**
     * @return the countryName mengambil nilai dari county_name
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName the countryName to set memberikan/memasukkan nilai ke country_name
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * @return the regionId mengambil nilai dari region_id
     */
    public int getRegionId() {
        return regionId;
    }

    /**
     * @param regionId the regionId to set memberikan/memasukkan nilai ke region_id
     */
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
    
    
}
