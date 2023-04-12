package com.bbva.datioamproduct.fdevdatio

import com.bbva.datioamproduct.fdevdatio.utils.IOUtils
import com.datio.dataproc.sdk.api.SparkProcess
import com.datio.dataproc.sdk.api.context.RuntimeContext
import com.typesafe.config.Config
import org.apache.spark.sql.DataFrame
import org.slf4j.{Logger, LoggerFactory}

class DatioSparkProcess extends SparkProcess with IOUtils{
  private val logger:Logger = LoggerFactory.getLogger(this.getClass)
  override def runProcess(runtimeContext: RuntimeContext):Int = {
    logger.info("Hola Mensaje que nos indica que esta listo para ser utilizado")
    val config: Config = runtimeContext.getConfig
    val nbaPlayerInputConfig: Config =config.getConfig("DatioJob.input.nba_player_pergame")
    val nbaDF:DataFrame = read(nbaPlayerInputConfig)
    nbaDF.printSchema()
    nbaDF.show()
    0
  }

  override def getProcessId: String = "DatioSparkProcess"

}
