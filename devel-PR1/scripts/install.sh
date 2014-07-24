#!/bin/bash


declare prefix="/usr";
declare hocl_lib_dir="lib/hocl";
declare bin_dir="bin";


# process the arguments

while [[ "${1}" != "" ]]; do
	case ${1} in
		--prefix)
			if [[ "${2}" == "" ]]; then
				echo "You need to specify a prefix! See install.sh --help for more info";
				exit 1;
			fi
			prefix="${2}";
			shift;
			;;
		--no-prefix)
			prefix="";
			;;
		--help)
			echo "Installs HOCL - Higher Order Chemical Language";
			echo "Usage: ${0} [--prefix dir][--no-prefix][--help]";
			echo "   --prefix dir    set the directory to use as the root of the";
			echo "                   system (default: ${prefix})";
			echo "   --no-prefix     do not use any prefix (installs in /)";
			echo "   --help          this help screen";
			exit;
			;;
	esac
	shift;
done

# install the files

install -d "${prefix}/${bin_dir}";
install -d "${prefix}/${hocl_lib_dir}";
install *.jar "${prefix}/${hocl_lib_dir}";
install hoclcompile hoclrun "${prefix}/${hocl_lib_dir}";

# change the default hocl path in hoclcompile

sed -e "s|^readonly HOCL_DEF_PATH=.*|readonly HOCL_DEF_PATH=\"${prefix}/${hocl_lib_dir}\";|g" "${prefix}/${hocl_lib_dir}/hoclcompile" >> "${prefix}/${hocl_lib_dir}/hoclcompile-tmp";
mv "${prefix}/${hocl_lib_dir}/hoclcompile-tmp" "${prefix}/${hocl_lib_dir}/hoclcompile";
chmod 0755 "${prefix}/${hocl_lib_dir}/hoclcompile";

# create the links

ln -s "${prefix}/${hocl_lib_dir}/hoclcompile" "${prefix}/${bin_dir}/hoclcompile";
ln -s "${prefix}/${hocl_lib_dir}/hoclrun" "${prefix}/${bin_dir}/hoclrun";

ln -s "/usr/lib/hocl/hoclcompile" "/usr/bin/hoclcompile";

exit;

