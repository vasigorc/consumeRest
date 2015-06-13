/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consumerest.beans;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vasigorc
 */
@XmlRootElement(name="City")
public class City {
    //convert to type int when/if necessary
    private String id;
    private String url;
    private String large_url;
    private String source_id;
    private String copyright;
    private String site;

    public City(String id, String url, String large_url, String source_id, String copyright, String site) {
        super();
        this.id = id;
        this.url = url;
        this.large_url = large_url;
        this.source_id = source_id;
        this.copyright = copyright;
        this.site = site;
    }

    public City() {
    }
        
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLarge_url() {
        return large_url;
    }

    public void setLarge_url(String large_url) {
        this.large_url = large_url;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }
    
    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
    
    @Override
    public int hashCode(){
        int h1 = id.hashCode();
        int h2 = copyright.hashCode();
        int h3 = large_url.hashCode();
        int h4 = site.hashCode();
        int h5 = url.hashCode();
                
        final int HASH_MULTIPLIER = 31;
        
        int sum = HASH_MULTIPLIER*h1+h2+h3+h4+h5;
       
        return sum;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final City other = (City) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.large_url, other.large_url)) {
            return false;
        }
        if (!Objects.equals(this.source_id, other.source_id)) {
            return false;
        }
        if (!Objects.equals(this.copyright, other.copyright)) {
            return false;
        }
        return Objects.equals(this.site, other.site);
    }
    
    @Override
    public String toString(){
        return "City {id: "+this.id+", url: "+this.url+", large_url: "
                +this.large_url+", source_id: "+this.source_id+", copyright: "
                +this.copyright+", site: "+this.site+"}";
    }
}
