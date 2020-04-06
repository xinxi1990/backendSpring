#!/usr/bin/env bash


nohup java -javaagent:/data/apache-skywalking-apm-bin/agent/skywalking-agent.jar -Dskywalking.agent.service_name=nacos-provider -Dskywalking.collector.backend_service=localhost:11800 -jar backendapp-1.0.jar &

java -javaagent:/Users/xinxi/Documents/apache-skywalking-apm-bin/agent/skywalking-agent.jar -Dskywalking.agent.service_name=nacos-provider -Dskywalking.collector.backend_service=127.0.0.1:11800 -jar backendapp-1.0.jar


