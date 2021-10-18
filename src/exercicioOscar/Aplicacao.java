package exercicioOscar;

import exercicioOscar.pessoas.Ator;
import exercicioOscar.pessoas.Atriz;
import exercicioOscar.pessoas.Pessoa;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Aplicacao {
    public static void main(String[] args) {
        List <Atriz>atrizes = new ArrayList<>();
        List <Atriz>atrizesExTres = new ArrayList<>() ;
        List<Pessoa>pessoas = new ArrayList<>();
        List <Ator>atores = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(System.getProperty("user.home"), "atrizes.csv"))) {
            List<String>linhasAtriz = stream.skip(1).collect(Collectors.toList());
            List<Atriz>atrizesTry = converterEmAtriz(linhasAtriz);
            List<Pessoa>pessoasTryAtrizes = converterEmPessoa(linhasAtriz);
            atrizesTry.forEach(System.out::println);
            System.out.println("\n");
            atrizes = List.copyOf(atrizesTry);
            pessoas.addAll(pessoasTryAtrizes);


        } catch (IOException e) {
            e.printStackTrace();

        }   try (Stream<String> stream = Files.lines(Paths.get(System.getProperty("user.home"), "atores.csv"))) {
            List<String>linhasAtor = stream.skip(1).collect(Collectors.toList());
            List<Ator>atoresTry = converterEmAtor(linhasAtor);
            List<Pessoa>pessoasTryator = converterEmPessoa(linhasAtor);

            atoresTry.forEach(System.out::println);
            System.out.println("\n");
            atores = List.copyOf(atoresTry);
            pessoas.addAll(pessoasTryator);

        } catch (IOException e) {
            e.printStackTrace();
        }


        for(int i=0; i< pessoas.size();i++){
            System.out.println("Pessoa "+pessoas.get(i).getNomePessoa());
        }
        //Exercicio 1
        Optional<Ator> atorOptional = atores.stream().min(Comparator.comparingInt(Ator::getIdade));
        atorOptional.ifPresent(System.out::println);

        //Exercicio2
        Map<String,Long> atrizGanhadora = atrizes.stream().map(Atriz::getNomeAtriz).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        atrizGanhadora.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).ifPresent(c-> System.out.println("\nA atriz que mais ganhou o premio do oscar foi: "+c.getKey()));

        //Exercicio 3
        for(int i=0; i<atrizes.size(); i++){
            if((atrizes.get(i).getIdade() > 20)&&(atrizes.get(i).getIdade()<30)){
                atrizesExTres.add(atrizes.get(i));
            }
        }
        Map<String,Long> atrizExTres = atrizesExTres.stream().map(Atriz::getNomeAtriz).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        atrizExTres.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).ifPresent(c-> System.out.println("\nA atriz entre 20 e 30 anos que mais ganhou o premio do oscar foi: "+c.getKey()+"\n"));

        //Exercicio 4
        Map<String,Long> pessoaExQuatro = pessoas.stream().map(Pessoa::getNomePessoa).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        List exQuatro = pessoaExQuatro.entrySet().stream().filter(p -> p.getValue() > 1).collect(Collectors.toList());
        exQuatro.forEach(System.out::println);

    }

    private static List<Pessoa> converterEmPessoa(List<String> linhasPessoa) {
        List<Pessoa> resultadoPessoa = new ArrayList<>();
        for (String linha : linhasPessoa){
            String[] campos = linha.split("; ");
            Pessoa novaPessoa = new Pessoa(Integer.parseInt(campos[1]), (Integer.parseInt(campos[2])), campos[3], campos[4]);
            resultadoPessoa.add(novaPessoa);
        }
        return resultadoPessoa;
    }


    private static List<Ator> converterEmAtor(List<String> linhasAtor) {
        List<Ator> resultadoAtor = new ArrayList<>();
        for (String linha : linhasAtor){
            String[] campos = linha.split("; ");
            Ator novoAtor = new Ator(Integer.parseInt(campos[1]), (Integer.parseInt(campos[2])), campos[3], campos[4]);
            resultadoAtor.add(novoAtor);
        }
        return resultadoAtor;
    }

    private static List<Atriz> converterEmAtriz(List<String> linhasAtriz) {
            List<Atriz> resultadoAtriz = new ArrayList<>();
            for (String linha : linhasAtriz){
                    String[] campos = linha.split("; ");
                    Atriz novaAtriz = new Atriz(Integer.parseInt(campos[1]), (Integer.parseInt(campos[2])), campos[3], campos[4]);
                    resultadoAtriz.add(novaAtriz);
        }
        return resultadoAtriz;
    }
}