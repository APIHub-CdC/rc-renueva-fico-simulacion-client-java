package io.RCRenuevaFico.client.api;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.RcRenuevaFico.client.ApiClient;
import io.RcRenuevaFico.client.api.ReporteDeCrditoRenuevaConFicoScoreApi;
import io.RcRenuevaFico.client.model.CatalogoEstados;
import io.RcRenuevaFico.client.model.DomicilioPeticion;
import io.RcRenuevaFico.client.model.PersonaPeticion;
import io.RcRenuevaFico.client.model.Respuesta;
import okhttp3.OkHttpClient;

public class ReporteDeCrditoRenuevaConFicoScoreApiTest {
	
private Logger logger = LoggerFactory.getLogger(ReporteDeCrditoRenuevaConFicoScoreApiTest.class.getName());
	
    private final ReporteDeCrditoRenuevaConFicoScoreApi api = new ReporteDeCrditoRenuevaConFicoScoreApi();

    private ApiClient apiClient;
    private String xApiKey = "Your Apikey";
    private String url = "Url";
    
    @Before()
    public void setUp() {
    	 
		this.apiClient = api.getApiClient();
        this.apiClient.setBasePath(url);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
               .readTimeout(30, TimeUnit.SECONDS)
               .build();
        apiClient.setHttpClient(okHttpClient);
    }
    
    @Test
    public void getReporteTest() throws Exception {
        //String xApiKey = null;
        PersonaPeticion request = new PersonaPeticion();
        DomicilioPeticion domicilio = new DomicilioPeticion();
        
        domicilio.setDireccion("");
        domicilio.setColoniaPoblacion("");
        domicilio.setDelegacionMunicipio("");
        domicilio.setCiudad("");
        domicilio.setEstado(CatalogoEstados.CDMX);
        domicilio.setCP("");
        
        request.setApellidoPaterno("");
        request.setApellidoMaterno("");
        request.setPrimerNombre("");
        request.setFechaNacimiento("");
        request.setRFC("");
        request.setNacionalidad("");
        request.setCuenta("");
        request.setDomicilio(domicilio);
        
        Respuesta response = api.getReporte(this.xApiKey, request);
        System.out.println(response.toString());
        logger.info("Report: "+response.toString());
        
        Assert.assertTrue(response.getFolioConsulta() != null);
    }
    
    
}
