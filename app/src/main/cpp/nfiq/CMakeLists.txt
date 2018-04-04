#
# Copyright (C) 2016 The Android Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "ASacs.c IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Build one shared lib. When we build, we set the bin to $user/tmp, and
# remove it after build complete, so only the distribution place could be
# used for application linking.

cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_VERBOSE_MAKEFILE on)

add_library(loop STATIC src/lib/nfiq/loop.c)
target_include_directories(loop PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(znorm SHARED src/lib/nfiq/znorm.c)
target_include_directories(znorm PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(ridges SHARED src/lib/nfiq/ridges.c)
target_include_directories(ridges PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(ssxstats SHARED src/lib/nfiq/ssxstats.c)
target_include_directories(ssxstats PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(acs SHARED src/lib/nfiq/acs.c)
target_include_directories(acs PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(remove SHARED src/lib/nfiq/remove.c)
target_include_directories(remove PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(runmlp SHARED src/lib/nfiq/runmlp.c)
target_include_directories(runmlp PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(memalloc SHARED src/lib/nfiq/memalloc.c)
target_include_directories(memalloc PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(syserr SHARED src/lib/nfiq/syserr.c)
target_include_directories(syserr PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(chaincod SHARED src/lib/nfiq/chaincod.c)
target_include_directories(chaincod PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(shape SHARED src/lib/nfiq/shape.c)
target_include_directories(shape PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(link SHARED src/lib/nfiq/link.c)
target_include_directories(link PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(matchpat SHARED src/lib/nfiq/matchpat.c)
target_include_directories(matchpat PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(binar SHARED src/lib/nfiq/binar.c)
target_include_directories(binar PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(morph SHARED src/lib/nfiq/morph.c)
target_include_directories(morph PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(sort SHARED src/lib/nfiq/sort.c)
target_include_directories(sort PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(dft SHARED src/lib/nfiq/dft.c)
target_include_directories(dft PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(globals SHARED src/lib/nfiq/globals.c)
target_include_directories(globals PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(util SHARED src/lib/nfiq/util.c)
target_include_directories(util PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(fatalerr SHARED src/lib/nfiq/fatalerr.c)
target_include_directories(fatalerr PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(contour SHARED src/lib/nfiq/contour.c)
target_include_directories(contour PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(line SHARED src/lib/nfiq/line.c)
target_include_directories(line PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(imgutil SHARED src/lib/nfiq/imgutil.c)
target_include_directories(imgutil PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(free SHARED src/lib/nfiq/free.c)
target_include_directories(free PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(init SHARED src/lib/nfiq/init.c)
target_include_directories(init PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(block SHARED src/lib/nfiq/block.c)
target_include_directories(block PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(mlpcla SHARED src/lib/nfiq/mlpcla.c)
target_include_directories(mlpcla PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(maps SHARED src/lib/nfiq/maps.c)
target_include_directories(maps PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(log SHARED src/lib/nfiq/log.c)
target_include_directories(log PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(quality SHARED src/lib/nfiq/quality.c)
target_include_directories(quality PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(detect SHARED src/lib/nfiq/detect.c)
target_include_directories(detect PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(sgemv SHARED src/lib/nfiq/sgemv.c)
target_include_directories(sgemv PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(getmin SHARED src/lib/nfiq/getmin.c)
target_include_directories(getmin PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)


add_library(minutia STATIC src/lib/nfiq/minutia.c)
target_include_directories(minutia PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(xytreps SHARED src/lib/nfiq/xytreps.c)
target_include_directories(xytreps PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(sscal SHARED src/lib/nfiq/sscal.c)
target_include_directories(sscal PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(saxpy SHARED src/lib/nfiq/saxpy.c)
target_include_directories(saxpy PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(snrm2 SHARED src/lib/nfiq/snrm2.c)
target_include_directories(snrm2 PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(sdot SHARED src/lib/nfiq/sdot.c)
target_include_directories(sdot PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(lsame SHARED src/lib/nfiq/lsame.c)
target_include_directories(lsame PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)


add_library(xerbla SHARED src/lib/nfiq/xerbla.c)
target_include_directories(xerbla PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(nfiqgbls SHARED src/lib/nfiq/nfiqgbls.c)
target_include_directories(nfiqgbls PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(nfiq SHARED src/lib/nfiq/nfiq.c)
target_include_directories(nfiq PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)

add_library(nativelib SHARED native_lib.c)
target_include_directories(nativelib PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/include/)



#TARGET LINK SECTION
target_link_libraries(quality maps)

target_link_libraries(link log loop imgutil)

target_link_libraries(chaincod globals)

target_link_libraries(shape contour sort)

target_link_libraries(loop minutia chaincod shape)

target_link_libraries(remove minutia link)

target_link_libraries(minutia maps matchpat contour line loop)

target_link_libraries(contour util globals)

target_link_libraries(imgutil line contour)

target_link_libraries(getmin detect quality)

target_link_libraries(dft sort)

target_link_libraries(matchpat globals)

target_link_libraries(binar imgutil)

target_link_libraries(ridges log sort imgutil line contour minutia)

target_link_libraries(detect log init free imgutil maps binar minutia remove ridges)

target_link_libraries(maps block log init free dft morph util)

target_link_libraries(znorm ssxstats)

target_link_libraries(sgemv lsame xerbla)

target_link_libraries(mlpcla sgemv sscal saxpy sdot snrm2)

target_link_libraries(runmlp memalloc fatalerr acs mlpcla)

target_link_libraries(memalloc syserr)

target_link_libraries(nfiq znorm nfiqgbls minutia getmin runmlp)

target_link_libraries(nativelib nfiq)

