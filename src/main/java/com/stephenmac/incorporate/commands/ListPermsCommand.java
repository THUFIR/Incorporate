package com.stephenmac.incorporate.commands;

import com.stephenmac.incorporate.ArgParser;
import com.stephenmac.incorporate.Executor;
import com.stephenmac.incorporate.Permission;
import com.stephenmac.incorporate.Rank;

public class ListPermsCommand extends Command {
	
	public ListPermsCommand(ArgParser p, Executor cmdExec) {
		super(p, cmdExec);
		usage = "<rank>";
		perms.add(Permission.BASIC);
	}

	@Override
	public String execute() {
		Rank r = getCompany().getRank(p.args.get(0));
		if (r == null){
			return "No such rank";
		}
		else{
			StringBuilder s = new StringBuilder();
			for (Permission p : r.permissions){
				s.append(p.toString() + " ");
			}
			s.deleteCharAt(s.length()-1);
			return s.toString();
		}
	}

}
