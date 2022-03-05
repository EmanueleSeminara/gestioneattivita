package it.prova.gestioneattivita.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestioneattivita.model.Attivita;

public class UtilityAttivitaForm {
	public static Attivita createAttivitaFromParams(String titoloInputParam, String descrizioneInputParam,
			String prioritaInputStringParam, String dataStringParam) {
		Attivita result = new Attivita(titoloInputParam);
		result.setDescrizione(descrizioneInputParam);

		if (NumberUtils.isCreatable(prioritaInputStringParam)) {
			result.setPriorita(Integer.parseInt(prioritaInputStringParam));

		}
		result.setData(parseDateArrivoFromString(dataStringParam));

		return result;
	}

	public static boolean validateAttivitaBean(Attivita attivitaToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(attivitaToBeValidated.getTitolo()) || attivitaToBeValidated.getPriorita() == null
				|| attivitaToBeValidated.getPriorita() < 1 || attivitaToBeValidated.getPriorita() > 4) {

			return false;
		}
		return true;
	}

	public static Date parseDateArrivoFromString(String dataStringParam) {
		if (StringUtils.isBlank(dataStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataStringParam);
		} catch (ParseException e) {
			return null;
		}
	}
}
