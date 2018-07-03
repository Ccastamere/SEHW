#Docker简介
Docker是一个开源的引擎，可以轻松的为任何应用创建一个轻量级的、可移植的、自给自足的容器。开发者在笔记本上编译测试通过的容器可以批量地在生产环境中部署，包括VMs（虚拟机）、bare metal、OpenStack 集群和其他的基础应用平台。
Docker通常用于如下场景：
*web应用的自动化打包和发布；
*自动化测试和持续集成、发布；
*在服务型环境中部署和调整数据库或其他的后台应用；
*从头编译或者扩展现有的OpenShift或Cloud Foundry平台来搭建自己的PaaS环境。
#Docker 的优点
*简化程序：Docker 让开发者可以打包他们的应用以及依赖包到一个可移植的容器中，然后发布到任何流行的 Linux 机器上，便可以实现虚拟化。Docker改变了虚拟化的方式，使开发者可以直接将自己的成果放入Docker中进行管理。方便快捷已经是 Docker的最大优势，过去需要用数天乃至数周的 任务，在Docker容器的处理下，只需要数秒就能完成。
*避免选择恐惧症：如果你有选择恐惧症，还是资深患者。Docker 帮你 打包你的纠结！比如 Docker 镜像；Docker 镜像中包含了运行环境和配置，所以 Docker 可以简化部署多种应用实例工作。比如 Web 应用、后台应用、数据库应用、大数据应用比如 Hadoop 集群、消息队列等等都可以打包成一个镜像部署。
*节省开支：一方面，云计算时代到来，使开发者不必为了追求效果而配置高额的硬件，Docker 改变了高性能必然高价格的思维定势。Docker 与云的结合，让云空间得到更充分的利用。不仅解决了硬件管理的问题，也改变了虚拟化的方式。    
#准备工作
##环境条件：
*linux系统，不建议windows
*docker最新版本
*jdk 1.8
*maven3.0
#改造工程、构建镜像
##改造eureka-server工程
*在pom文件加上插件：
*Spotify 的 docker-maven-plugin 插件是用maven插件方式构建docker镜像的。
**imageName指定了镜像的名字
**dockerDirectory指定 Dockerfile 的位置
**resources是指那些需要和 Dockerfile 放在一起，在构建镜像时使用的文件，一般应用 jar 包需要纳入。
*修改下配置文件
*编写dockerfile文件
*docker file编写指令：
#采用docker-compose启动镜像
*Compose 是一个用于定义和运行多容器的Docker应用的工具。使用Compose，可以在一个配置文件（yaml格式）中配置应用的服务，然后使用一个命令，即可创建并启动配置中引用的所有服务。下面我们进入Compose的实战吧。
*采用docker-compose的方式编排镜像，启动镜像
#采用docker-compose编排并启动镜像
docker-compose也可以构建镜像，我们采用docker-compose的方式构建镜像。
