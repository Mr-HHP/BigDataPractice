package my.bigdata.spark.sql;

import saprk.sql.catalyst.parser.SqlBaseParser;
import saprk.sql.catalyst.parser.SqlBaseParserBaseVisitor;

public class MyVisitor extends SqlBaseParserBaseVisitor<String> {
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSingleStatement(SqlBaseParser.SingleStatementContext ctx) {
        return super.visitSingleStatement(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSingleExpression(SqlBaseParser.SingleExpressionContext ctx) {
        return super.visitSingleExpression(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSingleTableIdentifier(SqlBaseParser.SingleTableIdentifierContext ctx) {
        return super.visitSingleTableIdentifier(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSingleMultipartIdentifier(SqlBaseParser.SingleMultipartIdentifierContext ctx) {
        return super.visitSingleMultipartIdentifier(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSingleFunctionIdentifier(SqlBaseParser.SingleFunctionIdentifierContext ctx) {
        return super.visitSingleFunctionIdentifier(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSingleDataType(SqlBaseParser.SingleDataTypeContext ctx) {
        return super.visitSingleDataType(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSingleTableSchema(SqlBaseParser.SingleTableSchemaContext ctx) {
        return super.visitSingleTableSchema(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitStatementDefault(SqlBaseParser.StatementDefaultContext ctx) {
        return super.visitStatementDefault(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDmlStatement(SqlBaseParser.DmlStatementContext ctx) {
        return super.visitDmlStatement(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitUse(SqlBaseParser.UseContext ctx) {
        return super.visitUse(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitUseNamespace(SqlBaseParser.UseNamespaceContext ctx) {
        return super.visitUseNamespace(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSetCatalog(SqlBaseParser.SetCatalogContext ctx) {
        return super.visitSetCatalog(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCreateNamespace(SqlBaseParser.CreateNamespaceContext ctx) {
        return super.visitCreateNamespace(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSetNamespaceProperties(SqlBaseParser.SetNamespacePropertiesContext ctx) {
        return super.visitSetNamespaceProperties(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSetNamespaceLocation(SqlBaseParser.SetNamespaceLocationContext ctx) {
        return super.visitSetNamespaceLocation(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDropNamespace(SqlBaseParser.DropNamespaceContext ctx) {
        return super.visitDropNamespace(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitShowNamespaces(SqlBaseParser.ShowNamespacesContext ctx) {
        return super.visitShowNamespaces(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCreateTable(SqlBaseParser.CreateTableContext ctx) {
        return super.visitCreateTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCreateTableLike(SqlBaseParser.CreateTableLikeContext ctx) {
        return super.visitCreateTableLike(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitReplaceTable(SqlBaseParser.ReplaceTableContext ctx) {
        return super.visitReplaceTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitAnalyze(SqlBaseParser.AnalyzeContext ctx) {
        return super.visitAnalyze(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitAnalyzeTables(SqlBaseParser.AnalyzeTablesContext ctx) {
        return super.visitAnalyzeTables(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitAddTableColumns(SqlBaseParser.AddTableColumnsContext ctx) {
        return super.visitAddTableColumns(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRenameTableColumn(SqlBaseParser.RenameTableColumnContext ctx) {
        return super.visitRenameTableColumn(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDropTableColumns(SqlBaseParser.DropTableColumnsContext ctx) {
        return super.visitDropTableColumns(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRenameTable(SqlBaseParser.RenameTableContext ctx) {
        return super.visitRenameTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSetTableProperties(SqlBaseParser.SetTablePropertiesContext ctx) {
        return super.visitSetTableProperties(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitUnsetTableProperties(SqlBaseParser.UnsetTablePropertiesContext ctx) {
        return super.visitUnsetTableProperties(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitAlterTableAlterColumn(SqlBaseParser.AlterTableAlterColumnContext ctx) {
        return super.visitAlterTableAlterColumn(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitHiveChangeColumn(SqlBaseParser.HiveChangeColumnContext ctx) {
        return super.visitHiveChangeColumn(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitHiveReplaceColumns(SqlBaseParser.HiveReplaceColumnsContext ctx) {
        return super.visitHiveReplaceColumns(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSetTableSerDe(SqlBaseParser.SetTableSerDeContext ctx) {
        return super.visitSetTableSerDe(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitAddTablePartition(SqlBaseParser.AddTablePartitionContext ctx) {
        return super.visitAddTablePartition(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRenameTablePartition(SqlBaseParser.RenameTablePartitionContext ctx) {
        return super.visitRenameTablePartition(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDropTablePartitions(SqlBaseParser.DropTablePartitionsContext ctx) {
        return super.visitDropTablePartitions(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSetTableLocation(SqlBaseParser.SetTableLocationContext ctx) {
        return super.visitSetTableLocation(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRecoverPartitions(SqlBaseParser.RecoverPartitionsContext ctx) {
        return super.visitRecoverPartitions(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDropTable(SqlBaseParser.DropTableContext ctx) {
        return super.visitDropTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDropView(SqlBaseParser.DropViewContext ctx) {
        return super.visitDropView(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCreateView(SqlBaseParser.CreateViewContext ctx) {
        return super.visitCreateView(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCreateTempViewUsing(SqlBaseParser.CreateTempViewUsingContext ctx) {
        return super.visitCreateTempViewUsing(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitAlterViewQuery(SqlBaseParser.AlterViewQueryContext ctx) {
        return super.visitAlterViewQuery(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCreateFunction(SqlBaseParser.CreateFunctionContext ctx) {
        return super.visitCreateFunction(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDropFunction(SqlBaseParser.DropFunctionContext ctx) {
        return super.visitDropFunction(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitExplain(SqlBaseParser.ExplainContext ctx) {
        return super.visitExplain(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitShowTables(SqlBaseParser.ShowTablesContext ctx) {
        return super.visitShowTables(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitShowTableExtended(SqlBaseParser.ShowTableExtendedContext ctx) {
        return super.visitShowTableExtended(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitShowTblProperties(SqlBaseParser.ShowTblPropertiesContext ctx) {
        return super.visitShowTblProperties(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitShowColumns(SqlBaseParser.ShowColumnsContext ctx) {
        return super.visitShowColumns(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitShowViews(SqlBaseParser.ShowViewsContext ctx) {
        return super.visitShowViews(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitShowPartitions(SqlBaseParser.ShowPartitionsContext ctx) {
        return super.visitShowPartitions(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitShowFunctions(SqlBaseParser.ShowFunctionsContext ctx) {
        return super.visitShowFunctions(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitShowCreateTable(SqlBaseParser.ShowCreateTableContext ctx) {
        return super.visitShowCreateTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitShowCurrentNamespace(SqlBaseParser.ShowCurrentNamespaceContext ctx) {
        return super.visitShowCurrentNamespace(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitShowCatalogs(SqlBaseParser.ShowCatalogsContext ctx) {
        return super.visitShowCatalogs(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDescribeFunction(SqlBaseParser.DescribeFunctionContext ctx) {
        return super.visitDescribeFunction(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDescribeNamespace(SqlBaseParser.DescribeNamespaceContext ctx) {
        return super.visitDescribeNamespace(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDescribeRelation(SqlBaseParser.DescribeRelationContext ctx) {
        return super.visitDescribeRelation(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDescribeQuery(SqlBaseParser.DescribeQueryContext ctx) {
        return super.visitDescribeQuery(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCommentNamespace(SqlBaseParser.CommentNamespaceContext ctx) {
        return super.visitCommentNamespace(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCommentTable(SqlBaseParser.CommentTableContext ctx) {
        return super.visitCommentTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRefreshTable(SqlBaseParser.RefreshTableContext ctx) {
        return super.visitRefreshTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRefreshFunction(SqlBaseParser.RefreshFunctionContext ctx) {
        return super.visitRefreshFunction(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRefreshResource(SqlBaseParser.RefreshResourceContext ctx) {
        return super.visitRefreshResource(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCacheTable(SqlBaseParser.CacheTableContext ctx) {
        return super.visitCacheTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitUncacheTable(SqlBaseParser.UncacheTableContext ctx) {
        return super.visitUncacheTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitClearCache(SqlBaseParser.ClearCacheContext ctx) {
        return super.visitClearCache(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitLoadData(SqlBaseParser.LoadDataContext ctx) {
        return super.visitLoadData(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTruncateTable(SqlBaseParser.TruncateTableContext ctx) {
        return super.visitTruncateTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRepairTable(SqlBaseParser.RepairTableContext ctx) {
        return super.visitRepairTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitManageResource(SqlBaseParser.ManageResourceContext ctx) {
        return super.visitManageResource(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFailNativeCommand(SqlBaseParser.FailNativeCommandContext ctx) {
        return super.visitFailNativeCommand(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSetTimeZone(SqlBaseParser.SetTimeZoneContext ctx) {
        return super.visitSetTimeZone(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSetQuotedConfiguration(SqlBaseParser.SetQuotedConfigurationContext ctx) {
        return super.visitSetQuotedConfiguration(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSetConfiguration(SqlBaseParser.SetConfigurationContext ctx) {
        return super.visitSetConfiguration(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitResetQuotedConfiguration(SqlBaseParser.ResetQuotedConfigurationContext ctx) {
        return super.visitResetQuotedConfiguration(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitResetConfiguration(SqlBaseParser.ResetConfigurationContext ctx) {
        return super.visitResetConfiguration(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCreateIndex(SqlBaseParser.CreateIndexContext ctx) {
        return super.visitCreateIndex(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDropIndex(SqlBaseParser.DropIndexContext ctx) {
        return super.visitDropIndex(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitConfigKey(SqlBaseParser.ConfigKeyContext ctx) {
        return super.visitConfigKey(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitConfigValue(SqlBaseParser.ConfigValueContext ctx) {
        return super.visitConfigValue(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitUnsupportedHiveNativeCommands(SqlBaseParser.UnsupportedHiveNativeCommandsContext ctx) {
        return super.visitUnsupportedHiveNativeCommands(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCreateTableHeader(SqlBaseParser.CreateTableHeaderContext ctx) {
        return super.visitCreateTableHeader(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitReplaceTableHeader(SqlBaseParser.ReplaceTableHeaderContext ctx) {
        return super.visitReplaceTableHeader(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitBucketSpec(SqlBaseParser.BucketSpecContext ctx) {
        return super.visitBucketSpec(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSkewSpec(SqlBaseParser.SkewSpecContext ctx) {
        return super.visitSkewSpec(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitLocationSpec(SqlBaseParser.LocationSpecContext ctx) {
        return super.visitLocationSpec(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCommentSpec(SqlBaseParser.CommentSpecContext ctx) {
        return super.visitCommentSpec(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitQuery(SqlBaseParser.QueryContext ctx) {
        return super.visitQuery(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitInsertOverwriteTable(SqlBaseParser.InsertOverwriteTableContext ctx) {
        return super.visitInsertOverwriteTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitInsertIntoTable(SqlBaseParser.InsertIntoTableContext ctx) {
        return super.visitInsertIntoTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitInsertOverwriteHiveDir(SqlBaseParser.InsertOverwriteHiveDirContext ctx) {
        return super.visitInsertOverwriteHiveDir(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitInsertOverwriteDir(SqlBaseParser.InsertOverwriteDirContext ctx) {
        return super.visitInsertOverwriteDir(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPartitionSpecLocation(SqlBaseParser.PartitionSpecLocationContext ctx) {
        return super.visitPartitionSpecLocation(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPartitionSpec(SqlBaseParser.PartitionSpecContext ctx) {
        return super.visitPartitionSpec(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPartitionVal(SqlBaseParser.PartitionValContext ctx) {
        return super.visitPartitionVal(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitNamespace(SqlBaseParser.NamespaceContext ctx) {
        return super.visitNamespace(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitNamespaces(SqlBaseParser.NamespacesContext ctx) {
        return super.visitNamespaces(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDescribeFuncName(SqlBaseParser.DescribeFuncNameContext ctx) {
        return super.visitDescribeFuncName(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDescribeColName(SqlBaseParser.DescribeColNameContext ctx) {
        return super.visitDescribeColName(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCtes(SqlBaseParser.CtesContext ctx) {
        return super.visitCtes(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitNamedQuery(SqlBaseParser.NamedQueryContext ctx) {
        return super.visitNamedQuery(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTableProvider(SqlBaseParser.TableProviderContext ctx) {
        return super.visitTableProvider(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCreateTableClauses(SqlBaseParser.CreateTableClausesContext ctx) {
        return super.visitCreateTableClauses(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPropertyList(SqlBaseParser.PropertyListContext ctx) {
        return super.visitPropertyList(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitProperty(SqlBaseParser.PropertyContext ctx) {
        return super.visitProperty(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPropertyKey(SqlBaseParser.PropertyKeyContext ctx) {
        return super.visitPropertyKey(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPropertyValue(SqlBaseParser.PropertyValueContext ctx) {
        return super.visitPropertyValue(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitConstantList(SqlBaseParser.ConstantListContext ctx) {
        return super.visitConstantList(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitNestedConstantList(SqlBaseParser.NestedConstantListContext ctx) {
        return super.visitNestedConstantList(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCreateFileFormat(SqlBaseParser.CreateFileFormatContext ctx) {
        return super.visitCreateFileFormat(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTableFileFormat(SqlBaseParser.TableFileFormatContext ctx) {
        return super.visitTableFileFormat(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitGenericFileFormat(SqlBaseParser.GenericFileFormatContext ctx) {
        return super.visitGenericFileFormat(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitStorageHandler(SqlBaseParser.StorageHandlerContext ctx) {
        return super.visitStorageHandler(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitResource(SqlBaseParser.ResourceContext ctx) {
        return super.visitResource(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSingleInsertQuery(SqlBaseParser.SingleInsertQueryContext ctx) {
        return super.visitSingleInsertQuery(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitMultiInsertQuery(SqlBaseParser.MultiInsertQueryContext ctx) {
        return super.visitMultiInsertQuery(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDeleteFromTable(SqlBaseParser.DeleteFromTableContext ctx) {
        return super.visitDeleteFromTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitUpdateTable(SqlBaseParser.UpdateTableContext ctx) {
        return super.visitUpdateTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitMergeIntoTable(SqlBaseParser.MergeIntoTableContext ctx) {
        return super.visitMergeIntoTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitQueryOrganization(SqlBaseParser.QueryOrganizationContext ctx) {
        return super.visitQueryOrganization(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitMultiInsertQueryBody(SqlBaseParser.MultiInsertQueryBodyContext ctx) {
        return super.visitMultiInsertQueryBody(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitQueryTermDefault(SqlBaseParser.QueryTermDefaultContext ctx) {
        return super.visitQueryTermDefault(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSetOperation(SqlBaseParser.SetOperationContext ctx) {
        return super.visitSetOperation(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitQueryPrimaryDefault(SqlBaseParser.QueryPrimaryDefaultContext ctx) {
        return super.visitQueryPrimaryDefault(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFromStmt(SqlBaseParser.FromStmtContext ctx) {
        return super.visitFromStmt(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTable(SqlBaseParser.TableContext ctx) {
        return super.visitTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitInlineTableDefault1(SqlBaseParser.InlineTableDefault1Context ctx) {
        return super.visitInlineTableDefault1(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSubquery(SqlBaseParser.SubqueryContext ctx) {
        return super.visitSubquery(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSortItem(SqlBaseParser.SortItemContext ctx) {
        return super.visitSortItem(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFromStatement(SqlBaseParser.FromStatementContext ctx) {
        return super.visitFromStatement(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFromStatementBody(SqlBaseParser.FromStatementBodyContext ctx) {
        return super.visitFromStatementBody(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTransformQuerySpecification(SqlBaseParser.TransformQuerySpecificationContext ctx) {
        return super.visitTransformQuerySpecification(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRegularQuerySpecification(SqlBaseParser.RegularQuerySpecificationContext ctx) {
        return super.visitRegularQuerySpecification(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTransformClause(SqlBaseParser.TransformClauseContext ctx) {
        return super.visitTransformClause(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSelectClause(SqlBaseParser.SelectClauseContext ctx) {
        return super.visitSelectClause(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSetClause(SqlBaseParser.SetClauseContext ctx) {
        return super.visitSetClause(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitMatchedClause(SqlBaseParser.MatchedClauseContext ctx) {
        return super.visitMatchedClause(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitNotMatchedClause(SqlBaseParser.NotMatchedClauseContext ctx) {
        return super.visitNotMatchedClause(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitMatchedAction(SqlBaseParser.MatchedActionContext ctx) {
        return super.visitMatchedAction(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitNotMatchedAction(SqlBaseParser.NotMatchedActionContext ctx) {
        return super.visitNotMatchedAction(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitAssignmentList(SqlBaseParser.AssignmentListContext ctx) {
        return super.visitAssignmentList(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitAssignment(SqlBaseParser.AssignmentContext ctx) {
        return super.visitAssignment(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitWhereClause(SqlBaseParser.WhereClauseContext ctx) {
        return super.visitWhereClause(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitHavingClause(SqlBaseParser.HavingClauseContext ctx) {
        return super.visitHavingClause(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitHint(SqlBaseParser.HintContext ctx) {
        return super.visitHint(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitHintStatement(SqlBaseParser.HintStatementContext ctx) {
        return super.visitHintStatement(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFromClause(SqlBaseParser.FromClauseContext ctx) {
        return super.visitFromClause(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTemporalClause(SqlBaseParser.TemporalClauseContext ctx) {
        return super.visitTemporalClause(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitAggregationClause(SqlBaseParser.AggregationClauseContext ctx) {
        return super.visitAggregationClause(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitGroupByClause(SqlBaseParser.GroupByClauseContext ctx) {
        return super.visitGroupByClause(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitGroupingAnalytics(SqlBaseParser.GroupingAnalyticsContext ctx) {
        return super.visitGroupingAnalytics(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitGroupingElement(SqlBaseParser.GroupingElementContext ctx) {
        return super.visitGroupingElement(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitGroupingSet(SqlBaseParser.GroupingSetContext ctx) {
        return super.visitGroupingSet(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPivotClause(SqlBaseParser.PivotClauseContext ctx) {
        return super.visitPivotClause(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPivotColumn(SqlBaseParser.PivotColumnContext ctx) {
        return super.visitPivotColumn(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPivotValue(SqlBaseParser.PivotValueContext ctx) {
        return super.visitPivotValue(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitLateralView(SqlBaseParser.LateralViewContext ctx) {
        return super.visitLateralView(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSetQuantifier(SqlBaseParser.SetQuantifierContext ctx) {
        return super.visitSetQuantifier(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRelation(SqlBaseParser.RelationContext ctx) {
        return super.visitRelation(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitJoinRelation(SqlBaseParser.JoinRelationContext ctx) {
        return super.visitJoinRelation(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitJoinType(SqlBaseParser.JoinTypeContext ctx) {
        return super.visitJoinType(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitJoinCriteria(SqlBaseParser.JoinCriteriaContext ctx) {
        return super.visitJoinCriteria(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSample(SqlBaseParser.SampleContext ctx) {
        return super.visitSample(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSampleByPercentile(SqlBaseParser.SampleByPercentileContext ctx) {
        return super.visitSampleByPercentile(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSampleByRows(SqlBaseParser.SampleByRowsContext ctx) {
        return super.visitSampleByRows(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSampleByBucket(SqlBaseParser.SampleByBucketContext ctx) {
        return super.visitSampleByBucket(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSampleByBytes(SqlBaseParser.SampleByBytesContext ctx) {
        return super.visitSampleByBytes(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitIdentifierList(SqlBaseParser.IdentifierListContext ctx) {
        return super.visitIdentifierList(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitIdentifierSeq(SqlBaseParser.IdentifierSeqContext ctx) {
        return super.visitIdentifierSeq(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitOrderedIdentifierList(SqlBaseParser.OrderedIdentifierListContext ctx) {
        return super.visitOrderedIdentifierList(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitOrderedIdentifier(SqlBaseParser.OrderedIdentifierContext ctx) {
        return super.visitOrderedIdentifier(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitIdentifierCommentList(SqlBaseParser.IdentifierCommentListContext ctx) {
        return super.visitIdentifierCommentList(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitIdentifierComment(SqlBaseParser.IdentifierCommentContext ctx) {
        return super.visitIdentifierComment(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTableName(SqlBaseParser.TableNameContext ctx) {
        return super.visitTableName(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitAliasedQuery(SqlBaseParser.AliasedQueryContext ctx) {
        return super.visitAliasedQuery(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitAliasedRelation(SqlBaseParser.AliasedRelationContext ctx) {
        return super.visitAliasedRelation(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitInlineTableDefault2(SqlBaseParser.InlineTableDefault2Context ctx) {
        return super.visitInlineTableDefault2(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTableValuedFunction(SqlBaseParser.TableValuedFunctionContext ctx) {
        return super.visitTableValuedFunction(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitInlineTable(SqlBaseParser.InlineTableContext ctx) {
        return super.visitInlineTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFunctionTable(SqlBaseParser.FunctionTableContext ctx) {
        return super.visitFunctionTable(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTableAlias(SqlBaseParser.TableAliasContext ctx) {
        return super.visitTableAlias(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRowFormatSerde(SqlBaseParser.RowFormatSerdeContext ctx) {
        return super.visitRowFormatSerde(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRowFormatDelimited(SqlBaseParser.RowFormatDelimitedContext ctx) {
        return super.visitRowFormatDelimited(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitMultipartIdentifierList(SqlBaseParser.MultipartIdentifierListContext ctx) {
        return super.visitMultipartIdentifierList(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitMultipartIdentifier(SqlBaseParser.MultipartIdentifierContext ctx) {
        return super.visitMultipartIdentifier(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitMultipartIdentifierPropertyList(SqlBaseParser.MultipartIdentifierPropertyListContext ctx) {
        return super.visitMultipartIdentifierPropertyList(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitMultipartIdentifierProperty(SqlBaseParser.MultipartIdentifierPropertyContext ctx) {
        return super.visitMultipartIdentifierProperty(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTableIdentifier(SqlBaseParser.TableIdentifierContext ctx) {
        return super.visitTableIdentifier(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFunctionIdentifier(SqlBaseParser.FunctionIdentifierContext ctx) {
        return super.visitFunctionIdentifier(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitNamedExpression(SqlBaseParser.NamedExpressionContext ctx) {
        return super.visitNamedExpression(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitNamedExpressionSeq(SqlBaseParser.NamedExpressionSeqContext ctx) {
        return super.visitNamedExpressionSeq(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPartitionFieldList(SqlBaseParser.PartitionFieldListContext ctx) {
        return super.visitPartitionFieldList(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPartitionTransform(SqlBaseParser.PartitionTransformContext ctx) {
        return super.visitPartitionTransform(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPartitionColumn(SqlBaseParser.PartitionColumnContext ctx) {
        return super.visitPartitionColumn(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitIdentityTransform(SqlBaseParser.IdentityTransformContext ctx) {
        return super.visitIdentityTransform(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitApplyTransform(SqlBaseParser.ApplyTransformContext ctx) {
        return super.visitApplyTransform(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTransformArgument(SqlBaseParser.TransformArgumentContext ctx) {
        return super.visitTransformArgument(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitExpression(SqlBaseParser.ExpressionContext ctx) {
        return super.visitExpression(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitExpressionSeq(SqlBaseParser.ExpressionSeqContext ctx) {
        return super.visitExpressionSeq(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitLogicalNot(SqlBaseParser.LogicalNotContext ctx) {
        return super.visitLogicalNot(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPredicated(SqlBaseParser.PredicatedContext ctx) {
        return super.visitPredicated(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitExists(SqlBaseParser.ExistsContext ctx) {
        return super.visitExists(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitLogicalBinary(SqlBaseParser.LogicalBinaryContext ctx) {
        return super.visitLogicalBinary(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPredicate(SqlBaseParser.PredicateContext ctx) {
        return super.visitPredicate(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitValueExpressionDefault(SqlBaseParser.ValueExpressionDefaultContext ctx) {
        return super.visitValueExpressionDefault(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitComparison(SqlBaseParser.ComparisonContext ctx) {
        return super.visitComparison(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitArithmeticBinary(SqlBaseParser.ArithmeticBinaryContext ctx) {
        return super.visitArithmeticBinary(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitArithmeticUnary(SqlBaseParser.ArithmeticUnaryContext ctx) {
        return super.visitArithmeticUnary(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDatetimeUnit(SqlBaseParser.DatetimeUnitContext ctx) {
        return super.visitDatetimeUnit(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitStruct(SqlBaseParser.StructContext ctx) {
        return super.visitStruct(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDereference(SqlBaseParser.DereferenceContext ctx) {
        return super.visitDereference(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTimestampadd(SqlBaseParser.TimestampaddContext ctx) {
        return super.visitTimestampadd(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSubstring(SqlBaseParser.SubstringContext ctx) {
        return super.visitSubstring(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCast(SqlBaseParser.CastContext ctx) {
        return super.visitCast(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitLambda(SqlBaseParser.LambdaContext ctx) {
        return super.visitLambda(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitParenthesizedExpression(SqlBaseParser.ParenthesizedExpressionContext ctx) {
        return super.visitParenthesizedExpression(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitAny_value(SqlBaseParser.Any_valueContext ctx) {
        return super.visitAny_value(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTrim(SqlBaseParser.TrimContext ctx) {
        return super.visitTrim(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSimpleCase(SqlBaseParser.SimpleCaseContext ctx) {
        return super.visitSimpleCase(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCurrentLike(SqlBaseParser.CurrentLikeContext ctx) {
        return super.visitCurrentLike(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitColumnReference(SqlBaseParser.ColumnReferenceContext ctx) {
        return super.visitColumnReference(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRowConstructor(SqlBaseParser.RowConstructorContext ctx) {
        return super.visitRowConstructor(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitLast(SqlBaseParser.LastContext ctx) {
        return super.visitLast(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitStar(SqlBaseParser.StarContext ctx) {
        return super.visitStar(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitOverlay(SqlBaseParser.OverlayContext ctx) {
        return super.visitOverlay(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSubscript(SqlBaseParser.SubscriptContext ctx) {
        return super.visitSubscript(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTimestampdiff(SqlBaseParser.TimestampdiffContext ctx) {
        return super.visitTimestampdiff(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSubqueryExpression(SqlBaseParser.SubqueryExpressionContext ctx) {
        return super.visitSubqueryExpression(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitConstantDefault(SqlBaseParser.ConstantDefaultContext ctx) {
        return super.visitConstantDefault(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitExtract(SqlBaseParser.ExtractContext ctx) {
        return super.visitExtract(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPercentile(SqlBaseParser.PercentileContext ctx) {
        return super.visitPercentile(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFunctionCall(SqlBaseParser.FunctionCallContext ctx) {
        return super.visitFunctionCall(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSearchedCase(SqlBaseParser.SearchedCaseContext ctx) {
        return super.visitSearchedCase(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPosition(SqlBaseParser.PositionContext ctx) {
        return super.visitPosition(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFirst(SqlBaseParser.FirstContext ctx) {
        return super.visitFirst(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitNullLiteral(SqlBaseParser.NullLiteralContext ctx) {
        return super.visitNullLiteral(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitIntervalLiteral(SqlBaseParser.IntervalLiteralContext ctx) {
        return super.visitIntervalLiteral(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTypeConstructor(SqlBaseParser.TypeConstructorContext ctx) {
        return super.visitTypeConstructor(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitNumericLiteral(SqlBaseParser.NumericLiteralContext ctx) {
        return super.visitNumericLiteral(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitBooleanLiteral(SqlBaseParser.BooleanLiteralContext ctx) {
        return super.visitBooleanLiteral(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitStringLiteral(SqlBaseParser.StringLiteralContext ctx) {
        return super.visitStringLiteral(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitComparisonOperator(SqlBaseParser.ComparisonOperatorContext ctx) {
        return super.visitComparisonOperator(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitArithmeticOperator(SqlBaseParser.ArithmeticOperatorContext ctx) {
        return super.visitArithmeticOperator(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPredicateOperator(SqlBaseParser.PredicateOperatorContext ctx) {
        return super.visitPredicateOperator(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitBooleanValue(SqlBaseParser.BooleanValueContext ctx) {
        return super.visitBooleanValue(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitInterval(SqlBaseParser.IntervalContext ctx) {
        return super.visitInterval(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitErrorCapturingMultiUnitsInterval(SqlBaseParser.ErrorCapturingMultiUnitsIntervalContext ctx) {
        return super.visitErrorCapturingMultiUnitsInterval(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitMultiUnitsInterval(SqlBaseParser.MultiUnitsIntervalContext ctx) {
        return super.visitMultiUnitsInterval(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitErrorCapturingUnitToUnitInterval(SqlBaseParser.ErrorCapturingUnitToUnitIntervalContext ctx) {
        return super.visitErrorCapturingUnitToUnitInterval(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitUnitToUnitInterval(SqlBaseParser.UnitToUnitIntervalContext ctx) {
        return super.visitUnitToUnitInterval(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitIntervalValue(SqlBaseParser.IntervalValueContext ctx) {
        return super.visitIntervalValue(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitColPosition(SqlBaseParser.ColPositionContext ctx) {
        return super.visitColPosition(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitComplexDataType(SqlBaseParser.ComplexDataTypeContext ctx) {
        return super.visitComplexDataType(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitYearMonthIntervalDataType(SqlBaseParser.YearMonthIntervalDataTypeContext ctx) {
        return super.visitYearMonthIntervalDataType(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDayTimeIntervalDataType(SqlBaseParser.DayTimeIntervalDataTypeContext ctx) {
        return super.visitDayTimeIntervalDataType(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitPrimitiveDataType(SqlBaseParser.PrimitiveDataTypeContext ctx) {
        return super.visitPrimitiveDataType(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitQualifiedColTypeWithPositionList(SqlBaseParser.QualifiedColTypeWithPositionListContext ctx) {
        return super.visitQualifiedColTypeWithPositionList(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitQualifiedColTypeWithPosition(SqlBaseParser.QualifiedColTypeWithPositionContext ctx) {
        return super.visitQualifiedColTypeWithPosition(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDefaultExpression(SqlBaseParser.DefaultExpressionContext ctx) {
        return super.visitDefaultExpression(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitColTypeList(SqlBaseParser.ColTypeListContext ctx) {
        return super.visitColTypeList(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitColType(SqlBaseParser.ColTypeContext ctx) {
        return super.visitColType(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCreateOrReplaceTableColTypeList(SqlBaseParser.CreateOrReplaceTableColTypeListContext ctx) {
        return super.visitCreateOrReplaceTableColTypeList(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitCreateOrReplaceTableColType(SqlBaseParser.CreateOrReplaceTableColTypeContext ctx) {
        return super.visitCreateOrReplaceTableColType(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitComplexColTypeList(SqlBaseParser.ComplexColTypeListContext ctx) {
        return super.visitComplexColTypeList(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitComplexColType(SqlBaseParser.ComplexColTypeContext ctx) {
        return super.visitComplexColType(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitWhenClause(SqlBaseParser.WhenClauseContext ctx) {
        return super.visitWhenClause(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitWindowClause(SqlBaseParser.WindowClauseContext ctx) {
        return super.visitWindowClause(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitNamedWindow(SqlBaseParser.NamedWindowContext ctx) {
        return super.visitNamedWindow(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitWindowRef(SqlBaseParser.WindowRefContext ctx) {
        return super.visitWindowRef(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitWindowDef(SqlBaseParser.WindowDefContext ctx) {
        return super.visitWindowDef(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitWindowFrame(SqlBaseParser.WindowFrameContext ctx) {
        return super.visitWindowFrame(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFrameBound(SqlBaseParser.FrameBoundContext ctx) {
        return super.visitFrameBound(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitQualifiedNameList(SqlBaseParser.QualifiedNameListContext ctx) {
        return super.visitQualifiedNameList(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFunctionName(SqlBaseParser.FunctionNameContext ctx) {
        return super.visitFunctionName(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitQualifiedName(SqlBaseParser.QualifiedNameContext ctx) {
        return super.visitQualifiedName(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitErrorCapturingIdentifier(SqlBaseParser.ErrorCapturingIdentifierContext ctx) {
        return super.visitErrorCapturingIdentifier(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitErrorIdent(SqlBaseParser.ErrorIdentContext ctx) {
        return super.visitErrorIdent(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitRealIdent(SqlBaseParser.RealIdentContext ctx) {
        return super.visitRealIdent(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitIdentifier(SqlBaseParser.IdentifierContext ctx) {
        return super.visitIdentifier(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitUnquotedIdentifier(SqlBaseParser.UnquotedIdentifierContext ctx) {
        return super.visitUnquotedIdentifier(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitQuotedIdentifierAlternative(SqlBaseParser.QuotedIdentifierAlternativeContext ctx) {
        return super.visitQuotedIdentifierAlternative(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitQuotedIdentifier(SqlBaseParser.QuotedIdentifierContext ctx) {
        return super.visitQuotedIdentifier(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitExponentLiteral(SqlBaseParser.ExponentLiteralContext ctx) {
        return super.visitExponentLiteral(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDecimalLiteral(SqlBaseParser.DecimalLiteralContext ctx) {
        return super.visitDecimalLiteral(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitLegacyDecimalLiteral(SqlBaseParser.LegacyDecimalLiteralContext ctx) {
        return super.visitLegacyDecimalLiteral(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitIntegerLiteral(SqlBaseParser.IntegerLiteralContext ctx) {
        return super.visitIntegerLiteral(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitBigIntLiteral(SqlBaseParser.BigIntLiteralContext ctx) {
        return super.visitBigIntLiteral(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitSmallIntLiteral(SqlBaseParser.SmallIntLiteralContext ctx) {
        return super.visitSmallIntLiteral(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitTinyIntLiteral(SqlBaseParser.TinyIntLiteralContext ctx) {
        return super.visitTinyIntLiteral(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitDoubleLiteral(SqlBaseParser.DoubleLiteralContext ctx) {
        return super.visitDoubleLiteral(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitFloatLiteral(SqlBaseParser.FloatLiteralContext ctx) {
        return super.visitFloatLiteral(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitBigDecimalLiteral(SqlBaseParser.BigDecimalLiteralContext ctx) {
        return super.visitBigDecimalLiteral(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitAlterColumnAction(SqlBaseParser.AlterColumnActionContext ctx) {
        return super.visitAlterColumnAction(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitAnsiNonReserved(SqlBaseParser.AnsiNonReservedContext ctx) {
        return super.visitAnsiNonReserved(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitStrictNonReserved(SqlBaseParser.StrictNonReservedContext ctx) {
        return super.visitStrictNonReserved(ctx);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public String visitNonReserved(SqlBaseParser.NonReservedContext ctx) {
        return super.visitNonReserved(ctx);
    }
}