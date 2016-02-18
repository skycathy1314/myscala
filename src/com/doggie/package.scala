package com

/**
  * Created by kaiheng on 2016/2/13.
  */
import scala.io.Source
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.SparkContext._
import org.ansj.splitWord.analysis.ToAnalysis
import org.ansj.util.FilterModifWord

object doggie {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("C:/Users/kaiheng/IdeaProjects/myscala/src/chinese.txt", "GB2312")
    val contents = source.getLines.reduceLeft(_+_)
    //for (l <- lineIterator)
      println(contents) // l is a String

    //println(contents)
   // val conf = new SparkConf().setAppName("doggie");
   // val sc = new SparkContext(conf);
   // val textFile = sc.textFile("C:/Users/kaiheng/IdeaProjects/myscala/chinese.txt").count;
   // println(textFile+"keke");
    val temp = ToAnalysis.parse(contents);
    val filter = FilterModifWord.modifResult(temp);
    val words:Seq[(String)] = for(i <- Range(0, filter.size())) yield filter.get(i).getName();
    println(words);
  }
}
