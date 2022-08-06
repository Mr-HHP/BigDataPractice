package my.bigdata.spark.sql;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import saprk.sql.catalyst.parser.SqlBaseLexer;
import saprk.sql.catalyst.parser.SqlBaseParser;

public class ParserDriver {
    public static void main(String[] args) {
        String query = "";
        SqlBaseLexer lexer = new SqlBaseLexer(new ANTLRInputStream(query));
        SqlBaseParser parser = new SqlBaseParser(new CommonTokenStream(lexer));
        MyVisitor visitor = new MyVisitor();
        String res = visitor.visitSingleStatement(parser.singleStatement());
        System.out.println("res="+res);
    }
}
