# streaming WordCount for scala

## 更多资源
- https://github.com/opensourceteams/flink-example-all

## 简述
- Flink 流处理WordCount
- window netcat 发送流数据
- flink streaming 处理流处理，进行WordCount统计并输出到控制台

## 输入数据
```aidl
a a c
```

## 输入数据
```aidl
4> (c,1)
6> (a,2)
```

#### WordCount.scala
```aidl
package com.opensourceteams.bigdata.flink.example.streaming

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.api.scala._


object WordCountRun {

  def main(args: Array[String]): Unit = {
    val hostname : String = "localhost"
    val port : Int = 9000
    val env:StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val text:DataStream[String] = env.socketTextStream(hostname,port,'\n')

    val windowCounts = text.flatMap{ w => w.split("\\s")}
                        .map{w =>(w,1)}
      .keyBy(0)
      .timeWindow(Time.milliseconds(100))
      .sum(1)
    windowCounts.print()

    env.execute("test")
  }
}


```

#### pom.xml
```aidl
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>opensourceteams</groupId>
	<artifactId>flink-example-scala</artifactId>
	<version>0.1</version>
	<packaging>jar</packaging>

	<name>Flink Quickstart Job</name>
	<url>http://www.myorganization.org</url>

	<repositories>
		<repository>
			<id>apache.snapshots</id>
			<name>Apache Development Snapshot Repository</name>
			<url>https://repository.apache.org/content/repositories/snapshots/</url>
			<releases>
				<enabled>false</enabled>
			</releases>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
	</repositories>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<flink.version>1.9.1</flink.version>
		<scala.binary.version>2.11</scala.binary.version>
		<scala.version>2.11.12</scala.version>
	</properties>

	<dependencies>
		<!-- Apache Flink dependencies -->
		<!-- These dependencies are provided, because they should not be packaged into the JAR file. -->
		<dependency>
			<groupId>org.apache.flink</groupId>
			<artifactId>flink-scala_${scala.binary.version}</artifactId>
			<version>${flink.version}</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.apache.flink</groupId>
			<artifactId>flink-streaming-scala_${scala.binary.version}</artifactId>
			<version>${flink.version}</version>
			<scope>provided</scope>
		</dependency>

		<!-- Scala Library, provided by Flink as well. -->
		<dependency>
			<groupId>org.scala-lang</groupId>
			<artifactId>scala-library</artifactId>
			<version>${scala.version}</version>
			<scope>provided</scope>
		</dependency>

		<!-- Add connector dependencies here. They must be in the default scope (compile). -->

		<!-- Example:

		<dependency>
			<groupId>org.apache.flink</groupId>
			<artifactId>flink-connector-kafka-0.10_${scala.binary.version}</artifactId>
			<version>${flink.version}</version>
		</dependency>
		-->

		<!-- Add logging framework, to produce console output when running in the IDE. -->
		<!-- These dependencies are excluded from the application JAR by default. -->
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-log4j12</artifactId>
			<version>1.7.7</version>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
			<scope>runtime</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<!-- We use the maven-shade plugin to create a fat jar that contains all necessary dependencies. -->
			<!-- Change the value of <mainClass>...</mainClass> if your program entry point changes. -->
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-shade-plugin</artifactId>
				<version>3.0.0</version>
				<executions>
					<!-- Run shade goal on package phase -->
					<execution>
						<phase>package</phase>
						<goals>
							<goal>shade</goal>
						</goals>
						<configuration>
							<artifactSet>
								<excludes>
									<exclude>org.apache.flink:force-shading</exclude>
									<exclude>com.google.code.findbugs:jsr305</exclude>
									<exclude>org.slf4j:*</exclude>
									<exclude>log4j:*</exclude>
								</excludes>
							</artifactSet>
							<filters>
								<filter>
									<!-- Do not copy the signatures in the META-INF folder.
									Otherwise, this might cause SecurityExceptions when using the JAR. -->
									<artifact>*:*</artifact>
									<excludes>
										<exclude>META-INF/*.SF</exclude>
										<exclude>META-INF/*.DSA</exclude>
										<exclude>META-INF/*.RSA</exclude>
									</excludes>
								</filter>
							</filters>
							<transformers>
								<transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
									<mainClass>com.opensourceteams.bigdata.flink.example.StreamingJob</mainClass>
								</transformer>
							</transformers>
						</configuration>
					</execution>
				</executions>
			</plugin>

			<!-- Java Compiler -->
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.1</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
				</configuration>
			</plugin>

			<!-- Scala Compiler -->
			<plugin>
				<groupId>net.alchim31.maven</groupId>
				<artifactId>scala-maven-plugin</artifactId>
				<version>3.2.2</version>
				<executions>
					<execution>
						<goals>
							<goal>compile</goal>
							<goal>testCompile</goal>
						</goals>
					</execution>
				</executions>
			</plugin>

			<!-- Eclipse Scala Integration -->
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-eclipse-plugin</artifactId>
				<version>2.8</version>
				<configuration>
					<downloadSources>true</downloadSources>
					<projectnatures>
						<projectnature>org.scala-ide.sdt.core.scalanature</projectnature>
						<projectnature>org.eclipse.jdt.core.javanature</projectnature>
					</projectnatures>
					<buildcommands>
						<buildcommand>org.scala-ide.sdt.core.scalabuilder</buildcommand>
					</buildcommands>
					<classpathContainers>
						<classpathContainer>org.scala-ide.sdt.launching.SCALA_CONTAINER</classpathContainer>
						<classpathContainer>org.eclipse.jdt.launching.JRE_CONTAINER</classpathContainer>
					</classpathContainers>
					<excludes>
						<exclude>org.scala-lang:scala-library</exclude>
						<exclude>org.scala-lang:scala-compiler</exclude>
					</excludes>
					<sourceIncludes>
						<sourceInclude>**/*.scala</sourceInclude>
						<sourceInclude>**/*.java</sourceInclude>
					</sourceIncludes>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>build-helper-maven-plugin</artifactId>
				<version>1.7</version>
				<executions>
					<!-- Add src/main/scala to eclipse build path -->
					<execution>
						<id>add-source</id>
						<phase>generate-sources</phase>
						<goals>
							<goal>add-source</goal>
						</goals>
						<configuration>
							<sources>
								<source>src/main/scala</source>
							</sources>
						</configuration>
					</execution>
					<!-- Add src/test/scala to eclipse build path -->
					<execution>
						<id>add-test-source</id>
						<phase>generate-test-sources</phase>
						<goals>
							<goal>add-test-source</goal>
						</goals>
						<configuration>
							<sources>
								<source>src/test/scala</source>
							</sources>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>

	<!-- This profile helps to make things run out of the box in IntelliJ -->
	<!-- Its adds Flink's core classes to the runtime class path. -->
	<!-- Otherwise they are missing in IntelliJ, because the dependency is 'provided' -->
	<profiles>
		<profile>
			<id>add-dependencies-for-IDEA</id>

			<activation>
				<property>
					<name>idea.version</name>
				</property>
			</activation>

			<dependencies>
				<dependency>
					<groupId>org.apache.flink</groupId>
					<artifactId>flink-scala_${scala.binary.version}</artifactId>
					<version>${flink.version}</version>
					<scope>compile</scope>
				</dependency>
				<dependency>
					<groupId>org.apache.flink</groupId>
					<artifactId>flink-streaming-scala_${scala.binary.version}</artifactId>
					<version>${flink.version}</version>
					<scope>compile</scope>
				</dependency>
				<dependency>
					<groupId>org.scala-lang</groupId>
					<artifactId>scala-library</artifactId>
					<version>${scala.version}</version>
					<scope>compile</scope>
				</dependency>
			</dependencies>
		</profile>
	</profiles>

</project>


```