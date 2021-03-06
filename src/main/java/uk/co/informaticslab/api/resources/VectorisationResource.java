package uk.co.informaticslab.api.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.FeatureCollection;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Path("vectorize/")
public class VectorisationResource {

    /**
     * Takes a GeoJSON feature collection
     *
     * @return GeoJSON feature collection.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response vectorize(InputStream geoJsonFeatureCollection) {

        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(geoJsonFeatureCollection));
            String line = null;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error Parsing: - ");
        }

        try {
            FeatureCollection featureCollection =
                    new ObjectMapper().readValue(sb.toString(), FeatureCollection.class);



        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .build();
        }
        return Response.ok().build();

    }

}
