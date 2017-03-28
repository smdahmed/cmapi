package com.cmapi

import java.util.zip.{ZipEntry, ZipInputStream}

import com.cloudera.api.{ClouderaManagerClientBuilder, DataView}
import com.cloudera.api.v12.RootResourceV12
import com.typesafe.scalalogging.LazyLogging

object CMAPI extends LazyLogging {

  def main(args: Array[String]) : Unit = {

    logger.info("CM API Started")

    val apiRoot : RootResourceV12 =
      new ClouderaManagerClientBuilder()
        .withHost("quickstart.cloudera").withPort(7180)
        .withUsernamePassword("cloudera", "cloudera")
        .build().getRootV12()

    val clusters = apiRoot.getClustersResource.readClusters(DataView.SUMMARY)

    logger.info(s"Clusters found are: ${clusters}")

//
//    val clientConfig = apiRoot.getClustersResource().getClientConfig("localhost:7180")
//
//    val inputStream = new ZipInputStream(clientConfig.getInputStream)
//
//    var zipEntry : ZipEntry = inputStream.getNextEntry()
//
//    while( zipEntry != null) {
//
//      logger.info("Reading: " + zipEntry.getName)
//
//      zipEntry = inputStream.getNextEntry
//    }
//
//    inputStream.close()

  }
}