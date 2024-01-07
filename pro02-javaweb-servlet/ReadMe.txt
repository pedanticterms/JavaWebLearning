1.设置编码


2.Servlet 的继承关系
    1. 继承关系
        javax.servlet.Servlet 接口
            javax.servlet.GenericServlet 抽象类
                javax.servlet.http.HttpServlet 抽象类

    2. 相关方法
        javax.servlet.Servlet 接口:
            void init(config) - 初始化方法
            void service(request, response) - 服务方法
            void destroy() - 销毁方法

        javax.servlet.GenericServlet 抽象类
            void service(request, response) - 仍然是抽象的

        javax.servlet.http.HttpServlet 抽象类
            void service(request, response) - 不是抽象的
