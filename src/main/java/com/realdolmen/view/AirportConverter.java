package com.realdolmen.view;

import com.realdolmen.beans.AirportBean;
import com.realdolmen.domain.AirportEntity;

import javax.enterprise.inject.spi.CDI;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.ws.rs.NotFoundException;

@FacesConverter("airportConverter")
public class AirportConverter implements Converter {
   @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                AirportBean service = CDI.current().select(AirportBean.class).get();
                AirportEntity airport = service.findById(Long.parseLong(value));
                if (airport != null)
                    return airport;
                throw new NotFoundException("Id: " + value + " was not found");
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return String.valueOf(((AirportEntity) value).getId());
        } else {
            return null;
        }
    }
}
