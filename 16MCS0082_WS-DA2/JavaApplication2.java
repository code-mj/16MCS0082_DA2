/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author Mansi
 */
import org.apache.jena.*;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecException;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 

        // First we have load our rdf data into jena Model [First 2 Line]
        // It Contain All the data which is define in rdf file
FileManager.get().addLocatorClassLoader(JavaApplication2.class.getClassLoader());
        Model model = FileManager.get().loadModel("C:\\Users\\Mansi\\Documents\\NetBeansProjects\\JavaApplication2\\src\\javaapplication2\\data.rdf");

        String queryStrName = 
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +  
                "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " + 
                "SELECT * WHERE { " + 
" ?person foaf:name ?x ." + 
                " } ";
        Query queryName = QueryFactory.create(queryStrName);
        QueryExecution queExeName = QueryExecutionFactory.create(queryName, model);
        try
           {
            ResultSet resultsName = queExeName.execSelect();
            while(resultsName.hasNext()){
            QuerySolution slnName = resultsName.nextSolution();
            Literal name = slnName.getLiteral("x");
            System.out.println(name);
           }
            }
        finally{
            queExeName.close();
            }
     
    }
    
}
