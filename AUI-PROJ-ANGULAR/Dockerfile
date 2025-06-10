# Step 1: Build Angular app
FROM node:19 AS build

WORKDIR /app

# Install dependencies
COPY package*.json ./
RUN npm install

# Copy source files
COPY . .

# Build Angular app
RUN npm run build --prod

# Step 2: Serve Angular app with NGINX
FROM nginx:alpine

# Copy the custom NGINX configuration
COPY nginx.conf /etc/nginx/conf.d/default.conf
ADD docker/etc/nginx/templates/ /etc/nginx/templates/

# Copy the built Angular app from the previous stage
COPY --from=build /app/dist/aui-proj-angular/browser /usr/share/nginx/html

# Expose the port NGINX will listen to
EXPOSE 80

# Configure NGINX to serve the Angular app
CMD ["nginx", "-g", "daemon off;"]
