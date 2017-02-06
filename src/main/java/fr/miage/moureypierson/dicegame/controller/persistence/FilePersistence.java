package fr.miage.moureypierson.dicegame.controller.persistence;

import fr.miage.moureypierson.dicegame.controller.HighScores;
import fr.miage.moureypierson.dicegame.model.Persistable;
import fr.miage.moureypierson.dicegame.model.Player;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Properties;

/**
 * File persistence implementation of persistence unit.
 */
public class FilePersistence implements Persistence {


    private final Properties properties;

    public FilePersistence(Properties properties) {
        this.properties = properties;
    }

    public HighScores loadAll() {
        try {
            JAXBContext jc = JAXBContext.newInstance(HighScores.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            return (HighScores) unmarshaller.unmarshal(new File(properties.getProperty("file.location")));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return new HighScores();
    }

    @Override
    public void save(Persistable persistable) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(HighScores.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            HighScores highScores = loadAll();
            highScores.getPlayers().remove((Player) persistable);
            highScores.getPlayers().add((Player) persistable);
            marshaller.marshal(highScores, new File(properties.getProperty("file.location")));
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
