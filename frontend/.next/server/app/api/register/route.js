/*
 * ATTENTION: An "eval-source-map" devtool has been used.
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file with attached SourceMaps in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
(() => {
var exports = {};
exports.id = "app/api/register/route";
exports.ids = ["app/api/register/route"];
exports.modules = {

/***/ "next/dist/compiled/next-server/app-page.runtime.dev.js":
/*!*************************************************************************!*\
  !*** external "next/dist/compiled/next-server/app-page.runtime.dev.js" ***!
  \*************************************************************************/
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/compiled/next-server/app-page.runtime.dev.js");

/***/ }),

/***/ "next/dist/compiled/next-server/app-route.runtime.dev.js":
/*!**************************************************************************!*\
  !*** external "next/dist/compiled/next-server/app-route.runtime.dev.js" ***!
  \**************************************************************************/
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/compiled/next-server/app-route.runtime.dev.js");

/***/ }),

/***/ "../app-render/after-task-async-storage.external":
/*!***********************************************************************************!*\
  !*** external "next/dist/server/app-render/after-task-async-storage.external.js" ***!
  \***********************************************************************************/
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/server/app-render/after-task-async-storage.external.js");

/***/ }),

/***/ "../app-render/work-async-storage.external":
/*!*****************************************************************************!*\
  !*** external "next/dist/server/app-render/work-async-storage.external.js" ***!
  \*****************************************************************************/
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/server/app-render/work-async-storage.external.js");

/***/ }),

/***/ "./work-unit-async-storage.external":
/*!**********************************************************************************!*\
  !*** external "next/dist/server/app-render/work-unit-async-storage.external.js" ***!
  \**********************************************************************************/
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/server/app-render/work-unit-async-storage.external.js");

/***/ }),

/***/ "(rsc)/./node_modules/next/dist/build/webpack/loaders/next-app-loader/index.js?name=app%2Fapi%2Fregister%2Froute&page=%2Fapi%2Fregister%2Froute&appPaths=&pagePath=private-next-app-dir%2Fapi%2Fregister%2Froute.ts&appDir=%2FUsers%2Fcarolinacastro%2FDesktop%2FSmart_home_management_project%2Ffrontend%2Fapp&pageExtensions=tsx&pageExtensions=ts&pageExtensions=jsx&pageExtensions=js&rootDir=%2FUsers%2Fcarolinacastro%2FDesktop%2FSmart_home_management_project%2Ffrontend&isDev=true&tsconfigPath=tsconfig.json&basePath=&assetPrefix=&nextConfigOutput=&preferredRegion=&middlewareConfig=e30%3D!":
/*!**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/next/dist/build/webpack/loaders/next-app-loader/index.js?name=app%2Fapi%2Fregister%2Froute&page=%2Fapi%2Fregister%2Froute&appPaths=&pagePath=private-next-app-dir%2Fapi%2Fregister%2Froute.ts&appDir=%2FUsers%2Fcarolinacastro%2FDesktop%2FSmart_home_management_project%2Ffrontend%2Fapp&pageExtensions=tsx&pageExtensions=ts&pageExtensions=jsx&pageExtensions=js&rootDir=%2FUsers%2Fcarolinacastro%2FDesktop%2FSmart_home_management_project%2Ffrontend&isDev=true&tsconfigPath=tsconfig.json&basePath=&assetPrefix=&nextConfigOutput=&preferredRegion=&middlewareConfig=e30%3D! ***!
  \**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   patchFetch: () => (/* binding */ patchFetch),\n/* harmony export */   routeModule: () => (/* binding */ routeModule),\n/* harmony export */   serverHooks: () => (/* binding */ serverHooks),\n/* harmony export */   workAsyncStorage: () => (/* binding */ workAsyncStorage),\n/* harmony export */   workUnitAsyncStorage: () => (/* binding */ workUnitAsyncStorage)\n/* harmony export */ });\n/* harmony import */ var next_dist_server_route_modules_app_route_module_compiled__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! next/dist/server/route-modules/app-route/module.compiled */ \"(rsc)/./node_modules/next/dist/server/route-modules/app-route/module.compiled.js\");\n/* harmony import */ var next_dist_server_route_modules_app_route_module_compiled__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(next_dist_server_route_modules_app_route_module_compiled__WEBPACK_IMPORTED_MODULE_0__);\n/* harmony import */ var next_dist_server_route_kind__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! next/dist/server/route-kind */ \"(rsc)/./node_modules/next/dist/server/route-kind.js\");\n/* harmony import */ var next_dist_server_lib_patch_fetch__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! next/dist/server/lib/patch-fetch */ \"(rsc)/./node_modules/next/dist/server/lib/patch-fetch.js\");\n/* harmony import */ var next_dist_server_lib_patch_fetch__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(next_dist_server_lib_patch_fetch__WEBPACK_IMPORTED_MODULE_2__);\n/* harmony import */ var _Users_carolinacastro_Desktop_Smart_home_management_project_frontend_app_api_register_route_ts__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./app/api/register/route.ts */ \"(rsc)/./app/api/register/route.ts\");\n\n\n\n\n// We inject the nextConfigOutput here so that we can use them in the route\n// module.\nconst nextConfigOutput = \"\"\nconst routeModule = new next_dist_server_route_modules_app_route_module_compiled__WEBPACK_IMPORTED_MODULE_0__.AppRouteRouteModule({\n    definition: {\n        kind: next_dist_server_route_kind__WEBPACK_IMPORTED_MODULE_1__.RouteKind.APP_ROUTE,\n        page: \"/api/register/route\",\n        pathname: \"/api/register\",\n        filename: \"route\",\n        bundlePath: \"app/api/register/route\"\n    },\n    resolvedPagePath: \"/Users/carolinacastro/Desktop/Smart_home_management_project/frontend/app/api/register/route.ts\",\n    nextConfigOutput,\n    userland: _Users_carolinacastro_Desktop_Smart_home_management_project_frontend_app_api_register_route_ts__WEBPACK_IMPORTED_MODULE_3__\n});\n// Pull out the exports that we need to expose from the module. This should\n// be eliminated when we've moved the other routes to the new format. These\n// are used to hook into the route.\nconst { workAsyncStorage, workUnitAsyncStorage, serverHooks } = routeModule;\nfunction patchFetch() {\n    return (0,next_dist_server_lib_patch_fetch__WEBPACK_IMPORTED_MODULE_2__.patchFetch)({\n        workAsyncStorage,\n        workUnitAsyncStorage\n    });\n}\n\n\n//# sourceMappingURL=app-route.js.map//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiKHJzYykvLi9ub2RlX21vZHVsZXMvbmV4dC9kaXN0L2J1aWxkL3dlYnBhY2svbG9hZGVycy9uZXh0LWFwcC1sb2FkZXIvaW5kZXguanM/bmFtZT1hcHAlMkZhcGklMkZyZWdpc3RlciUyRnJvdXRlJnBhZ2U9JTJGYXBpJTJGcmVnaXN0ZXIlMkZyb3V0ZSZhcHBQYXRocz0mcGFnZVBhdGg9cHJpdmF0ZS1uZXh0LWFwcC1kaXIlMkZhcGklMkZyZWdpc3RlciUyRnJvdXRlLnRzJmFwcERpcj0lMkZVc2VycyUyRmNhcm9saW5hY2FzdHJvJTJGRGVza3RvcCUyRlNtYXJ0X2hvbWVfbWFuYWdlbWVudF9wcm9qZWN0JTJGZnJvbnRlbmQlMkZhcHAmcGFnZUV4dGVuc2lvbnM9dHN4JnBhZ2VFeHRlbnNpb25zPXRzJnBhZ2VFeHRlbnNpb25zPWpzeCZwYWdlRXh0ZW5zaW9ucz1qcyZyb290RGlyPSUyRlVzZXJzJTJGY2Fyb2xpbmFjYXN0cm8lMkZEZXNrdG9wJTJGU21hcnRfaG9tZV9tYW5hZ2VtZW50X3Byb2plY3QlMkZmcm9udGVuZCZpc0Rldj10cnVlJnRzY29uZmlnUGF0aD10c2NvbmZpZy5qc29uJmJhc2VQYXRoPSZhc3NldFByZWZpeD0mbmV4dENvbmZpZ091dHB1dD0mcHJlZmVycmVkUmVnaW9uPSZtaWRkbGV3YXJlQ29uZmlnPWUzMCUzRCEiLCJtYXBwaW5ncyI6Ijs7Ozs7Ozs7Ozs7Ozs7QUFBK0Y7QUFDdkM7QUFDcUI7QUFDOEM7QUFDM0g7QUFDQTtBQUNBO0FBQ0Esd0JBQXdCLHlHQUFtQjtBQUMzQztBQUNBLGNBQWMsa0VBQVM7QUFDdkI7QUFDQTtBQUNBO0FBQ0E7QUFDQSxLQUFLO0FBQ0w7QUFDQTtBQUNBLFlBQVk7QUFDWixDQUFDO0FBQ0Q7QUFDQTtBQUNBO0FBQ0EsUUFBUSxzREFBc0Q7QUFDOUQ7QUFDQSxXQUFXLDRFQUFXO0FBQ3RCO0FBQ0E7QUFDQSxLQUFLO0FBQ0w7QUFDMEY7O0FBRTFGIiwic291cmNlcyI6WyIiXSwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHsgQXBwUm91dGVSb3V0ZU1vZHVsZSB9IGZyb20gXCJuZXh0L2Rpc3Qvc2VydmVyL3JvdXRlLW1vZHVsZXMvYXBwLXJvdXRlL21vZHVsZS5jb21waWxlZFwiO1xuaW1wb3J0IHsgUm91dGVLaW5kIH0gZnJvbSBcIm5leHQvZGlzdC9zZXJ2ZXIvcm91dGUta2luZFwiO1xuaW1wb3J0IHsgcGF0Y2hGZXRjaCBhcyBfcGF0Y2hGZXRjaCB9IGZyb20gXCJuZXh0L2Rpc3Qvc2VydmVyL2xpYi9wYXRjaC1mZXRjaFwiO1xuaW1wb3J0ICogYXMgdXNlcmxhbmQgZnJvbSBcIi9Vc2Vycy9jYXJvbGluYWNhc3Ryby9EZXNrdG9wL1NtYXJ0X2hvbWVfbWFuYWdlbWVudF9wcm9qZWN0L2Zyb250ZW5kL2FwcC9hcGkvcmVnaXN0ZXIvcm91dGUudHNcIjtcbi8vIFdlIGluamVjdCB0aGUgbmV4dENvbmZpZ091dHB1dCBoZXJlIHNvIHRoYXQgd2UgY2FuIHVzZSB0aGVtIGluIHRoZSByb3V0ZVxuLy8gbW9kdWxlLlxuY29uc3QgbmV4dENvbmZpZ091dHB1dCA9IFwiXCJcbmNvbnN0IHJvdXRlTW9kdWxlID0gbmV3IEFwcFJvdXRlUm91dGVNb2R1bGUoe1xuICAgIGRlZmluaXRpb246IHtcbiAgICAgICAga2luZDogUm91dGVLaW5kLkFQUF9ST1VURSxcbiAgICAgICAgcGFnZTogXCIvYXBpL3JlZ2lzdGVyL3JvdXRlXCIsXG4gICAgICAgIHBhdGhuYW1lOiBcIi9hcGkvcmVnaXN0ZXJcIixcbiAgICAgICAgZmlsZW5hbWU6IFwicm91dGVcIixcbiAgICAgICAgYnVuZGxlUGF0aDogXCJhcHAvYXBpL3JlZ2lzdGVyL3JvdXRlXCJcbiAgICB9LFxuICAgIHJlc29sdmVkUGFnZVBhdGg6IFwiL1VzZXJzL2Nhcm9saW5hY2FzdHJvL0Rlc2t0b3AvU21hcnRfaG9tZV9tYW5hZ2VtZW50X3Byb2plY3QvZnJvbnRlbmQvYXBwL2FwaS9yZWdpc3Rlci9yb3V0ZS50c1wiLFxuICAgIG5leHRDb25maWdPdXRwdXQsXG4gICAgdXNlcmxhbmRcbn0pO1xuLy8gUHVsbCBvdXQgdGhlIGV4cG9ydHMgdGhhdCB3ZSBuZWVkIHRvIGV4cG9zZSBmcm9tIHRoZSBtb2R1bGUuIFRoaXMgc2hvdWxkXG4vLyBiZSBlbGltaW5hdGVkIHdoZW4gd2UndmUgbW92ZWQgdGhlIG90aGVyIHJvdXRlcyB0byB0aGUgbmV3IGZvcm1hdC4gVGhlc2Vcbi8vIGFyZSB1c2VkIHRvIGhvb2sgaW50byB0aGUgcm91dGUuXG5jb25zdCB7IHdvcmtBc3luY1N0b3JhZ2UsIHdvcmtVbml0QXN5bmNTdG9yYWdlLCBzZXJ2ZXJIb29rcyB9ID0gcm91dGVNb2R1bGU7XG5mdW5jdGlvbiBwYXRjaEZldGNoKCkge1xuICAgIHJldHVybiBfcGF0Y2hGZXRjaCh7XG4gICAgICAgIHdvcmtBc3luY1N0b3JhZ2UsXG4gICAgICAgIHdvcmtVbml0QXN5bmNTdG9yYWdlXG4gICAgfSk7XG59XG5leHBvcnQgeyByb3V0ZU1vZHVsZSwgd29ya0FzeW5jU3RvcmFnZSwgd29ya1VuaXRBc3luY1N0b3JhZ2UsIHNlcnZlckhvb2tzLCBwYXRjaEZldGNoLCAgfTtcblxuLy8jIHNvdXJjZU1hcHBpbmdVUkw9YXBwLXJvdXRlLmpzLm1hcCJdLCJuYW1lcyI6W10sImlnbm9yZUxpc3QiOltdLCJzb3VyY2VSb290IjoiIn0=\n//# sourceURL=webpack-internal:///(rsc)/./node_modules/next/dist/build/webpack/loaders/next-app-loader/index.js?name=app%2Fapi%2Fregister%2Froute&page=%2Fapi%2Fregister%2Froute&appPaths=&pagePath=private-next-app-dir%2Fapi%2Fregister%2Froute.ts&appDir=%2FUsers%2Fcarolinacastro%2FDesktop%2FSmart_home_management_project%2Ffrontend%2Fapp&pageExtensions=tsx&pageExtensions=ts&pageExtensions=jsx&pageExtensions=js&rootDir=%2FUsers%2Fcarolinacastro%2FDesktop%2FSmart_home_management_project%2Ffrontend&isDev=true&tsconfigPath=tsconfig.json&basePath=&assetPrefix=&nextConfigOutput=&preferredRegion=&middlewareConfig=e30%3D!\n");

/***/ }),

/***/ "(rsc)/./node_modules/next/dist/build/webpack/loaders/next-flight-client-entry-loader.js?server=true!":
/*!******************************************************************************************************!*\
  !*** ./node_modules/next/dist/build/webpack/loaders/next-flight-client-entry-loader.js?server=true! ***!
  \******************************************************************************************************/
/***/ (() => {



/***/ }),

/***/ "(ssr)/./node_modules/next/dist/build/webpack/loaders/next-flight-client-entry-loader.js?server=true!":
/*!******************************************************************************************************!*\
  !*** ./node_modules/next/dist/build/webpack/loaders/next-flight-client-entry-loader.js?server=true! ***!
  \******************************************************************************************************/
/***/ (() => {



/***/ }),

/***/ "(rsc)/./app/api/register/route.ts":
/*!***********************************!*\
  !*** ./app/api/register/route.ts ***!
  \***********************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   POST: () => (/* binding */ POST)\n/* harmony export */ });\n/* harmony import */ var next_server__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! next/server */ \"(rsc)/./node_modules/next/dist/api/server.js\");\n\nasync function POST(req) {\n    const body = await req.json();\n    const response = await fetch(\"http://localhost:8080/register\", {\n        method: \"POST\",\n        headers: {\n            \"Content-Type\": \"application/json\"\n        },\n        body: JSON.stringify({\n            email: body.email,\n            password: body.password,\n            fullName: body.fullName || \"Smart Home User\",\n            registrationCode: body.registrationCode || null\n        })\n    });\n    console.log(\"Sending to backend:\", {\n        email: body.email,\n        password: body.password,\n        fullName: body.fullName,\n        registrationCode: body.registrationCode\n    });\n    console.log(\"📥 Backend response:\", response.status, response.headers);\n    const text = await response.text();\n    if (!response.ok) {\n        return next_server__WEBPACK_IMPORTED_MODULE_0__.NextResponse.json({\n            error: text\n        }, {\n            status: response.status\n        });\n    }\n    return next_server__WEBPACK_IMPORTED_MODULE_0__.NextResponse.json({\n        message: text\n    });\n}\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiKHJzYykvLi9hcHAvYXBpL3JlZ2lzdGVyL3JvdXRlLnRzIiwibWFwcGluZ3MiOiI7Ozs7O0FBQXVEO0FBRWhELGVBQWVDLEtBQUtDLEdBQWdCO0lBQ3pDLE1BQU1DLE9BQU8sTUFBTUQsSUFBSUUsSUFBSTtJQUUzQixNQUFNQyxXQUFXLE1BQU1DLE1BQU0sa0NBQWtDO1FBQzdEQyxRQUFRO1FBQ1JDLFNBQVM7WUFDUCxnQkFBZ0I7UUFDbEI7UUFDQUwsTUFBTU0sS0FBS0MsU0FBUyxDQUFDO1lBQ25CQyxPQUFPUixLQUFLUSxLQUFLO1lBQ2pCQyxVQUFVVCxLQUFLUyxRQUFRO1lBQ3ZCQyxVQUFVVixLQUFLVSxRQUFRLElBQUk7WUFDM0JDLGtCQUFrQlgsS0FBS1csZ0JBQWdCLElBQUk7UUFDN0M7SUFDRjtJQUNBQyxRQUFRQyxHQUFHLENBQUMsdUJBQXVCO1FBQ2pDTCxPQUFPUixLQUFLUSxLQUFLO1FBQ2pCQyxVQUFVVCxLQUFLUyxRQUFRO1FBQ3ZCQyxVQUFVVixLQUFLVSxRQUFRO1FBQ3ZCQyxrQkFBa0JYLEtBQUtXLGdCQUFnQjtJQUN6QztJQUVBQyxRQUFRQyxHQUFHLENBQUMsd0JBQXdCWCxTQUFTWSxNQUFNLEVBQUVaLFNBQVNHLE9BQU87SUFDckUsTUFBTVUsT0FBTyxNQUFNYixTQUFTYSxJQUFJO0lBRWhDLElBQUksQ0FBQ2IsU0FBU2MsRUFBRSxFQUFFO1FBQ2hCLE9BQU9uQixxREFBWUEsQ0FBQ0ksSUFBSSxDQUFDO1lBQUVnQixPQUFPRjtRQUFLLEdBQUc7WUFBRUQsUUFBUVosU0FBU1ksTUFBTTtRQUFDO0lBQ3RFO0lBRUEsT0FBT2pCLHFEQUFZQSxDQUFDSSxJQUFJLENBQUM7UUFBRWlCLFNBQVNIO0lBQUs7QUFDM0MiLCJzb3VyY2VzIjpbIi9Vc2Vycy9jYXJvbGluYWNhc3Ryby9EZXNrdG9wL1NtYXJ0X2hvbWVfbWFuYWdlbWVudF9wcm9qZWN0L2Zyb250ZW5kL2FwcC9hcGkvcmVnaXN0ZXIvcm91dGUudHMiXSwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHsgTmV4dFJlcXVlc3QsIE5leHRSZXNwb25zZSB9IGZyb20gXCJuZXh0L3NlcnZlclwiXG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBQT1NUKHJlcTogTmV4dFJlcXVlc3QpIHtcbiAgY29uc3QgYm9keSA9IGF3YWl0IHJlcS5qc29uKClcblxuICBjb25zdCByZXNwb25zZSA9IGF3YWl0IGZldGNoKFwiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3JlZ2lzdGVyXCIsIHtcbiAgICBtZXRob2Q6IFwiUE9TVFwiLFxuICAgIGhlYWRlcnM6IHtcbiAgICAgIFwiQ29udGVudC1UeXBlXCI6IFwiYXBwbGljYXRpb24vanNvblwiLFxuICAgIH0sXG4gICAgYm9keTogSlNPTi5zdHJpbmdpZnkoe1xuICAgICAgZW1haWw6IGJvZHkuZW1haWwsXG4gICAgICBwYXNzd29yZDogYm9keS5wYXNzd29yZCxcbiAgICAgIGZ1bGxOYW1lOiBib2R5LmZ1bGxOYW1lIHx8IFwiU21hcnQgSG9tZSBVc2VyXCIsXG4gICAgICByZWdpc3RyYXRpb25Db2RlOiBib2R5LnJlZ2lzdHJhdGlvbkNvZGUgfHwgbnVsbCxcbiAgICB9KSxcbiAgfSlcbiAgY29uc29sZS5sb2coXCJTZW5kaW5nIHRvIGJhY2tlbmQ6XCIsIHtcbiAgICBlbWFpbDogYm9keS5lbWFpbCxcbiAgICBwYXNzd29yZDogYm9keS5wYXNzd29yZCxcbiAgICBmdWxsTmFtZTogYm9keS5mdWxsTmFtZSxcbiAgICByZWdpc3RyYXRpb25Db2RlOiBib2R5LnJlZ2lzdHJhdGlvbkNvZGUsXG4gIH0pXG5cbiAgY29uc29sZS5sb2coXCLwn5OlIEJhY2tlbmQgcmVzcG9uc2U6XCIsIHJlc3BvbnNlLnN0YXR1cywgcmVzcG9uc2UuaGVhZGVycylcbiAgY29uc3QgdGV4dCA9IGF3YWl0IHJlc3BvbnNlLnRleHQoKVxuXG4gIGlmICghcmVzcG9uc2Uub2spIHtcbiAgICByZXR1cm4gTmV4dFJlc3BvbnNlLmpzb24oeyBlcnJvcjogdGV4dCB9LCB7IHN0YXR1czogcmVzcG9uc2Uuc3RhdHVzIH0pXG4gIH1cblxuICByZXR1cm4gTmV4dFJlc3BvbnNlLmpzb24oeyBtZXNzYWdlOiB0ZXh0IH0pXG59XG4iXSwibmFtZXMiOlsiTmV4dFJlc3BvbnNlIiwiUE9TVCIsInJlcSIsImJvZHkiLCJqc29uIiwicmVzcG9uc2UiLCJmZXRjaCIsIm1ldGhvZCIsImhlYWRlcnMiLCJKU09OIiwic3RyaW5naWZ5IiwiZW1haWwiLCJwYXNzd29yZCIsImZ1bGxOYW1lIiwicmVnaXN0cmF0aW9uQ29kZSIsImNvbnNvbGUiLCJsb2ciLCJzdGF0dXMiLCJ0ZXh0Iiwib2siLCJlcnJvciIsIm1lc3NhZ2UiXSwiaWdub3JlTGlzdCI6W10sInNvdXJjZVJvb3QiOiIifQ==\n//# sourceURL=webpack-internal:///(rsc)/./app/api/register/route.ts\n");

/***/ })

};
;

// load runtime
var __webpack_require__ = require("../../../webpack-runtime.js");
__webpack_require__.C(exports);
var __webpack_exec__ = (moduleId) => (__webpack_require__(__webpack_require__.s = moduleId))
var __webpack_exports__ = __webpack_require__.X(0, ["vendor-chunks/next"], () => (__webpack_exec__("(rsc)/./node_modules/next/dist/build/webpack/loaders/next-app-loader/index.js?name=app%2Fapi%2Fregister%2Froute&page=%2Fapi%2Fregister%2Froute&appPaths=&pagePath=private-next-app-dir%2Fapi%2Fregister%2Froute.ts&appDir=%2FUsers%2Fcarolinacastro%2FDesktop%2FSmart_home_management_project%2Ffrontend%2Fapp&pageExtensions=tsx&pageExtensions=ts&pageExtensions=jsx&pageExtensions=js&rootDir=%2FUsers%2Fcarolinacastro%2FDesktop%2FSmart_home_management_project%2Ffrontend&isDev=true&tsconfigPath=tsconfig.json&basePath=&assetPrefix=&nextConfigOutput=&preferredRegion=&middlewareConfig=e30%3D!")));
module.exports = __webpack_exports__;

})();