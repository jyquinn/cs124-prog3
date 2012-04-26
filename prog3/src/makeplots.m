close all;
xs = 1:50;

figure
hold on
% plot(xs, kk_res,'r')
plot(xs, stand_rr_res,'c')
plot(xs, stand_hc_res,'g')
plot(xs, stand_sa_res,'m')
title('Residues Using Standard Representation')
xlabel('Trial Number')
ylabel('Residue')
legend('Repeated Random','Hill Climbing','Simulated Annealing')


figure 
hold on
% plot(xs, kk_res,'r')
plot(xs, pre_rr_res,'c')
plot(xs, pre_hc_res,'g')
plot(xs, pre_sa_res,'m')
title('Residues Using Pre-Partitioning and KK')
xlabel('Trial Number')
ylabel('Residue')
legend('Repeated Random','Hill Climbing','Simulated Annealing')

figure
hold on
% plot(xs, kk_res,'r')
plot(xs, stand_rr_time,'c')
plot(xs, stand_hc_time,'g')
plot(xs, stand_sa_time,'m')
title('Time Using Standard Representation')
xlabel('Trial Number')
ylabel('Time (ms)')
legend('Repeated Random','Hill Climbing','Simulated Annealing')


figure
hold on
% plot(xs, kk_res,'r')
plot(xs, pre_rr_time,'c')
plot(xs, pre_hc_time,'g')
plot(xs, pre_sa_time,'m')
title('Time Using Pre-Partitioning and KK')
xlabel('Trial Number')
ylabel('Time (ms)')
legend('Repeated Random','Hill Climbing','Simulated Annealing')
