package Plan;
 
import Entities.EscalaActividades;
import Entity.ActividadesDiagnostico;
import Entity.CaracteristicasDefinitorias;
import Entity.CaracteristicasDiagnostico;
import Entity.Diagnostico;
import Entity.FactoresDiagnostico;
import Entity.FactoresRelacionado;
import Entity.IndicadoresDiagnostico;
import Entity.Nanda;
import Entity.NicDiagnostico;
import Entity.NocDiagnostico;
import Entity.Paciente;
import Entity.PatronFuncional;
import Entity.Useras;
import SessionBeans.CaracteristicasDefinitoriasFacade;
import SessionBeans.DiagnosticoFacade;
import SessionBeans.FactoresRelacionadoFacade;
import SessionBeans.NandaFacade;
import SessionBeans.PacienteFacade;
import SessionBeans.PatronFuncionalFacadeLocal;
import SessionBeans.ServicesBean;
import SessionBeans.UserasFacadeLocal;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Header;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
 
 
public class PdfDiagnostico extends HttpServlet {
    @EJB private PacienteFacade pacienteFacade;
    @EJB private UserasFacadeLocal userasFacade;
    @EJB private DiagnosticoFacade diagnosticoFacade;
    @EJB private CaracteristicasDefinitoriasFacade caracteristicasDefinitoriasFacade;
    @EJB private FactoresRelacionadoFacade factoresRelacionadoFacade;
    @EJB private PatronFuncionalFacadeLocal patronFuncionalFacade;
    @EJB private NandaFacade nandaFacade;
    @EJB private ServicesBean servicesBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            ByteArrayOutputStream pdfOutputStream = 
                 new ByteArrayOutputStream();
            
            Document document =  new Document(PageSize.A4, 60, 60, 110, 50);
            PdfWriter writer = PdfWriter.getInstance(document, pdfOutputStream);

            TableHeader event = new TableHeader();
            writer.setPageEvent(event);
            event.setHeader("Instituto Colombiano del Sistema Nervioso - Clínica Montserrat");
            
            document.addTitle("Plan de Atención Integral de Enfermería");
            document.addAuthor("Clínica Montserrat");
                
            document.open();
            
            if((Long)session.getAttribute("diagnostico") != -1){
                
                
                Diagnostico planAtencion =  diagnosticoFacade.findById((Long)session.getAttribute("diagnostico"));
                Useras enfermero = new Useras();
                enfermero.setNombre(planAtencion.getIdUseras());
                enfermero.setUsername(planAtencion.getIdUseras());
                Paciente paciente = servicesBean.buscarPaciente(planAtencion.getIdPaciente());


                document.add(new Paragraph("Plan de Atención Integral de Enfermería",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 20)));
                
                Calendar plan = Calendar.getInstance();
                plan.setTime(planAtencion.getFecha());

                Paragraph negrilla = new Paragraph("\nPAIE Nº: " + planAtencion.getId() + "     Fecha: " + 
                        plan.get(Calendar.DAY_OF_MONTH) + "/" + (plan.get(Calendar.MONTH) + 1) + "/" + plan.get(Calendar.YEAR)
                        + "\n\n", FontFactory.getFont(FontFactory.HELVETICA_BOLD));
                negrilla.add("Enfermero: \n");
                String segundoNombre = enfermero.getSegundoNombre();
                if(segundoNombre == null){
                    segundoNombre = "";
                }
                
                String segundoApellido = enfermero.getSegundoApellido();
                if(segundoApellido == null){
                    segundoApellido = "";
                }
                
                Paragraph paragraph = new Paragraph("Usuario: " + enfermero.getNombre());
                
                //+ " " + segundoNombre +
                //        "   Apellido: " + enfermero.getApellido() + " " + segundoApellido, FontFactory.getFont(FontFactory.TIMES));

                paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(negrilla);
                document.add(paragraph);

                negrilla.clear();
                paragraph.clear();
                
                
                Date fecha = paciente.getFechaDeNacimiento();
                Calendar cal = Calendar.getInstance();
                Calendar now = Calendar.getInstance();
                cal.setTime(fecha);

                int edad = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR) ;

                if(now.get(Calendar.MONTH) < cal.get(Calendar.MONTH)){
                    edad--;
                }
                if(now.get(Calendar.MONTH) == cal.get(Calendar.MONTH)){
                    if(now.get(Calendar.DAY_OF_MONTH) < cal.get(Calendar.DAY_OF_MONTH)){
                        edad--;
                    }
                }
                negrilla.add("\nPaciente:\n");
                paragraph.add("Documento: " + paciente.getDocumento() + "   Nombre: " + paciente.getNombre()
                        + "   Apellido: " + paciente.getApellido() + "\nFecha de Nacimiento: " + cal.get(Calendar.DAY_OF_MONTH) + "/" 
                        + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR) + "   Edad: " + edad);

                document.add(negrilla);
                document.add(paragraph);

                negrilla.clear();
                paragraph.clear();

                PatronFuncional patron =  patronFuncionalFacade.findById(BigDecimal.valueOf(planAtencion.getIdPatron()));

                negrilla.add("Patrón Funcional: ");
                paragraph.add(patron.getId() + " - " + patron.getDefinicion() + " - " + patron.getDescripcion());

                document.add(negrilla);
                document.add(paragraph);
                patron = null;
                negrilla.clear();
                paragraph.clear();

                Nanda n = nandaFacade.findById(planAtencion.getIdNanda());
                negrilla.add("\nDiagnóstico: ");
                paragraph.add(n.getCodigo() + " - " + n.getDiagnostico());

                document.add(negrilla);
                document.add(paragraph);
                n = null;
                negrilla.clear();
                paragraph.clear();

                List<CaracteristicasDiagnostico> caracteristicas = (List<CaracteristicasDiagnostico>) planAtencion.getCaracteristicasDiagnosticoCollection();
                List<FactoresDiagnostico> factores = (List<FactoresDiagnostico>)planAtencion.getFactoresDiagnosticoCollection();

                if(caracteristicas != null){
                    negrilla.add("\nCaracterísticas Definitorias:");
                    for(CaracteristicasDiagnostico i : caracteristicas){
                        CaracteristicasDefinitorias cd = caracteristicasDefinitoriasFacade.find(i.getIdCaracteristica().getId());
                        paragraph.add(cd.getId() + " - " + cd.getDefinicion() + "\n");
                    }

                    document.add(negrilla);
                    document.add(paragraph);
                    caracteristicas = null;
                    negrilla.clear();
                    paragraph.clear();
                }

                if(factores != null){
                    negrilla.add("\nFactores Relacionados:");
                    for(FactoresDiagnostico i : factores){
                        FactoresRelacionado fr = factoresRelacionadoFacade.find(i.getIdFactor().getId());
                        paragraph.add(fr.getId() + " - " + fr.getFactorRelacionado() + "\n");
                    }
                    document.add(negrilla);
                    document.add(paragraph);
                    factores = null;
                    negrilla.clear();
                    paragraph.clear();
                }

                negrilla.add("\nResultados NOC: ");
                List<NocDiagnostico> nocList = (List<NocDiagnostico>)planAtencion.getNocDiagnosticoCollection();
                for(NocDiagnostico t : nocList){
                    paragraph.add(t.getIdNoc().getId() + " - " + t.getIdNoc().getResultado() + " - " + t.getValorActual() + " - " + t.getValorDiana() + "\n");
                }

                document.add(negrilla);
                document.add(paragraph);
                factores = null;
                negrilla.clear();
                paragraph.clear();

                List<IndicadoresDiagnostico> indicadores = (List<IndicadoresDiagnostico>)planAtencion.getIndicadoresDiagnosticoCollection();

                negrilla.add("\nIndicadores: ");
                for(IndicadoresDiagnostico iv : indicadores){
                    paragraph.add(iv.getIdIndicador().getId() + " - " + iv.getIdIndicador().getIndicador() + " - " + iv.getValor() + "\n");
                }

                document.add(negrilla);
                document.add(paragraph);
                indicadores = null;
                negrilla.clear();
                paragraph.clear();

                List<NicDiagnostico> nics = (List<NicDiagnostico>)planAtencion.getNicDiagnosticoCollection();
                negrilla.add("\nNic: \n");
                for(NicDiagnostico nt : nics){
                    paragraph.add(nt.getIdNic().getId() + " - " + nt.getIdNic().getDefinicion()+ "\n");
                }


                document.add(negrilla);
                document.add(paragraph);
                nics = null;
                negrilla.clear();
                paragraph.clear();

                List<ActividadesDiagnostico> actividades = (List<ActividadesDiagnostico>)planAtencion.getActividadesDiagnosticoCollection();
                negrilla.add("\nActividades:\n");
                for(ActividadesDiagnostico an : actividades){
                    paragraph.add(an.getIdActividad().getCodigo() + " - " + an.getIdActividad().getActividad() + "\n");
                }

                document.add(negrilla);
                document.add(paragraph);
                nics = null;
                negrilla.clear();
                paragraph.clear();

                Long escala = planAtencion.getCaida();
                String escalaString = "";

                if(escala == 1){
                    escalaString = "Extremo";
                }
                if(escala == 2){
                    escalaString = "Alto";
                }
                if(escala == 3){
                    escalaString = "Medio";
                }
                if(escala == 4){
                    escalaString = "Bajo";
                }

                negrilla.add("\nActividades para " + escalaString + " de Caída:\n");
                if(escala == 1){
                    paragraph.add(EscalaActividades.EXTREMO);
                }
                if(escala == 2){
                    paragraph.add(EscalaActividades.ALTO);
                }
                if(escala == 3){
                    paragraph.add(EscalaActividades.MEDIO);
                }
                if(escala == 4){
                    paragraph.add(EscalaActividades.BAJO);
                }

                document.add(negrilla);
                document.add(paragraph);
                negrilla.clear();
                paragraph.clear();

                negrilla.add("\nActividades Riesgo de Caídas:\n");
                paragraph.add("1. Educar al paciente y sus familiares acerca del riesgo de caídas, las posibles consecuencias y medidas preventivas.\n" +
                "2. Indagar al paciente y su familiar acerca de antecedentes de caídas previas y factores desencadenantes. Adoptar las medidas de seguridad para controlarlos y minimizar el riesgo.\n" +
                "3. Verificar al recibo de turno que el timbre de llamado  esté cerca al paciente y funcionando de manera adecuada.\n" +
                "4. Confirmar que el paciente y sus familiares tengan claridad sobre la forma de accionar el sistema de llamado e informar la importancia de la solicitud de asistencia al personal de Enfermería para la realización de todas las actividades.\n" +
                "5. Facilitar el uso de dispositivos que mejoren la visión y audición, si el paciente utiliza gafas o audífonos, asegúrese de que los tenga puestos siempre. Si es necesario, proporciónele ayuda para la correcta colocación. \n" +
                "6. Favorecer un ambiente seguro para el paciente, retirar  todo elemento y corregir las condiciones del entorno que pueda generar caídas como cables e inmobiliario, piso húmedo en el recorrido del paciente.\n" +
                "7. Mantener la cama a la altura mínima del suelo, adecuada para que el paciente apoye los pies.\n" +
                "8. Dar respuesta oportuna al llamado del paciente (timbre).\n" +
                "9. Mantener los objetos personales (pañuelos, botella de agua) o institucionales (pato) de uso frecuente al alcance del paciente, así como los dispositivos de ayuda (caminador, bastón, muletas).\n" +
                "10. Mantener frenos accionados y las barandas arriba en camas y camillas, con mayor énfasis en pacientes (mayores de 60 años y lactantes mayores y preescolares), paciente que se encuentren bajo efectos de sedación, confusos, desorientados o intranquilos.  De igual manera sin distingo de la categoría de riesgo, mientras el paciente duerme. \n" +
                "11. Cuando un paciente sea sentado, debe hacerse en un sillón seguro y por un número de colaboradores acorde al peso y nivel de dependencia del paciente.\n" +
                "12. De acuerdo al nivel de autocontrol y cuando la condición clínica lo permita, según criterio de la Enfermera encargada del cuidado y/o médico tratante, para la deambulación  y desplazamientos, el paciente debe hacer uso de calzado antideslizante, preferiblemente cerrado y estar asistido por el personal de enfermería o por los familiares, de acuerdo a la clasificación del riesgo de caídas identificado.\n" +
                "13. Antes del traslado del paciente al baño, ducha u otros procedimientos, alistar todos los elementos necesarios: papel higiénico, jabón, toalla, cepillo de dientes, crema dental, máquina de rasurar, pantuflas, pijama… etc. Evitar dejar solo al paciente durante la actividad.\n" +
                "14. Trasladar el paciente al baño en  silla de ruedas cuando sus condiciones clínico patológicas lo permitan.  Esta silla debe ser UNICAMENTE utilizada para el traslado al baño, por ningún motivo el paciente debe permanecer sentado en ella, por el alto riesgo de caída al movilizarse en esta.\n" +
                "15. Utilizar una silla plástica en el baño del paciente para su uso durante la higiene personal en la ducha.\n" +
                "16. El baño en ducha debe ser asistido y supervisado por el auxiliar de enfermería asignado al cuidado del paciente.\n" +
                "17. Realizar rondas frecuentes para verificar las condiciones del paciente, atender llamado al timbre e identificar necesidades que requieran el apoyo de enfermería oportunamente (ofrecer pato para orinar repetidamente).\n" +
                "18. Identificar cambios en la evolución o comportamiento del paciente que requieran instaurar medidas de seguridad adicionales a las ya implementadas.\n" +
                "19. En caso de pacientes psiquiátricos y/o con ideas suicidas, se debe informar al médico tratante y solicitar el traslado del paciente a una habitación que permita brindarle mayor seguridad.\n" +
                "20. Reforzar permanentemente al paciente y sus familiares la importancia de mantener las medidas de seguridad y solicitar ayuda al personal de enfermería para la realización de cualquier actividad.\n" +
                "21. Solicitar a los familiares acompañamiento las 24 horas del día, cuando las condiciones clínicas o patológicas del paciente  lo amerite.\n" +
                "22. Trasladar al paciente en camilla con barandas siempre arriba y teniendo en cuenta las medidas de seguridad correspondientes a la clasificación del riesgo de caídas identificado.\n" +
                "23. Verificar que las ruedas de camillas y sillas estén libres de cualquier elemento que impida su libre rodamiento, de igual manera verificar que el sistema de frenos y barandas funcionen correctamente, antes de hacer uso de ellas para el traslado de pacientes.\n" +
                "24. Utilizar el freno de la cama, silla de ruedas o camilla cuando estas no se encuentren en movimiento.\n" +
                "25. Reportar a diario al área de mantenimiento las fallas o daños relacionados con el estado de camas, barandas, frenos, ruedas, camillas, sillas de ruedas, sillas fijas, escalerillas, timbre, sistema de iluminación y otros que puedan afectar la seguridad del paciente.\n" +
                "26. Mantener durante la noche iluminados los pasillos y/o  la luz del baño encendida, para evitar la penumbra en la unidad del paciente.");

                document.add(negrilla);
                document.add(paragraph);
            }else{
                document.addTitle("Plan de Atención Integral de Enfermería");
                document.addAuthor("Hospital");
                document.add(new Paragraph("Por Favor elija un diagnóstico.",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20)));

            }
            
            document.close();
            response.setHeader("Expires", "0");
            response.setContentType("application/pdf");
            response.setContentLength(pdfOutputStream.size());

            // Write the PDF
            ServletOutputStream responseOutputStream = 
                                response.getOutputStream();
            responseOutputStream.write(pdfOutputStream.toByteArray());
            responseOutputStream.flush();
            responseOutputStream.close();
        } catch (DocumentException ex) {
            Logger.getLogger(Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    
    class TableHeader extends PdfPageEventHelper {
        /** The header text. */
        String header;
        /** The template with the total number of pages. */
        PdfTemplate total;
 
        /**
         * Allows us to change the content of the header.
         * @param header The new header String
         */
        public void setHeader(String header) {
            this.header = header;
        }
 
        /**
         * Creates the PdfTemplate that will hold the total number of pages.
         * @see com.itextpdf.text.pdf.PdfPageEventHelper#onOpenDocument(
         *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
         */
        public void onOpenDocument(PdfWriter writer, Document document) {
            total = writer.getDirectContent().createTemplate(30, 16);
        }
 
        /**
         * Adds a header to every page
         * @see com.itextpdf.text.pdf.PdfPageEventHelper#onEndPage(
         *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
         */
        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            PdfPTable table = new PdfPTable(3);
            try {
                table.setWidths(new int[]{24, 10, 16});
                table.setTotalWidth(527);
                table.setLockedWidth(true);
                table.getDefaultCell().setFixedHeight(70);
                table.getDefaultCell().setBorder(Rectangle.BOTTOM);
                table.addCell(header);
                table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(String.format("Página %d", writer.getPageNumber()));
                table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(Image.getInstance(this.getClass().getResource("images/header.jpg")));
                table.writeSelectedRows(0, -1, 34, 803, writer.getDirectContent());
            }
            catch(DocumentException de) {
                throw new ExceptionConverter(de);
            } catch (MalformedURLException ex) {
                Logger.getLogger(PdfDiagnostico.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PdfDiagnostico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
        /**
         * Fills out the total number of pages before the document is closed.
         * @see com.itextpdf.text.pdf.PdfPageEventHelper#onCloseDocument(
         *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
         */
        public void onCloseDocument(PdfWriter writer, Document document) {
            ColumnText.showTextAligned(total, Element.ALIGN_LEFT,
                    new Phrase(String.valueOf(writer.getPageNumber() - 1)),
                    2, 2, 0);
        }
    }
        
    @Override
    public String getServletInfo() {
        return "My PDF Generator";
    }
}