# Usar una imagen base de Node.js
FROM node:20.10.0 AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar los archivos del proyecto
COPY package*.json ./
RUN npm install

COPY . .

# Construir la aplicación Angular
RUN npm run build

# Usar Nginx para servir la aplicación
FROM nginx:alpine
COPY --from=build /app/dist/front-app /usr/share/nginx/html

# Exponer el puerto 80
EXPOSE 80

# Comando para iniciar Nginx
CMD ["nginx", "-g", "daemon off;"]

