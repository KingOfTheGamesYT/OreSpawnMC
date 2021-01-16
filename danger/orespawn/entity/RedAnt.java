/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.init.ModDimensions;
/*     */ import danger.orespawn.util.Teleport;
/*     */ import danger.orespawn.util.ai.MyEntityAIWanderALot;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackMelee;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.DimensionType;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class RedAnt
/*     */   extends Ant
/*     */ {
/*  29 */   int attack_delay = 20;
/*  30 */   public double moveSpeed = 0.20000000298023224D;
/*     */   
/*     */   public RedAnt(World par1World) {
/*  33 */     super(par1World);
/*     */     
/*  35 */     setSize(0.2F, 0.2F);
/*     */     
/*  37 */     this.experienceValue = 1;
/*     */     
/*  39 */     this.tasks.addTask(0, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.399999976158142D));
/*  40 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0D, false));
/*  41 */     this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0D));
/*  42 */     if (OreSpawnMain.PlayNicely == 0) this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, true));
/*     */   
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public EntityAgeable createChild(EntityAgeable ageable) {
/*  48 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void applyEntityAttributes() {
/*  53 */     super.applyEntityAttributes();
/*  54 */     getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(mygetMaxHealth());
/*  55 */     getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.moveSpeed);
/*  56 */     getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int mygetMaxHealth() {
/*  62 */     return 2;
/*     */   }
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/*  66 */     if (OreSpawnMain.OreSpawnRand.nextInt(15) != 0) return false; 
/*  67 */     if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL) return false; 
/*  68 */     return par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean processInteract(EntityPlayer player, EnumHand hand) {
/*  74 */     ItemStack itemstack = player.getHeldItem(hand);
/*     */     
/*  76 */     if (itemstack.isEmpty())
/*     */     {
/*  78 */       if (player.dimension == DimensionType.OVERWORLD.getId()) {
/*  79 */         BlockPos playerPos = player.getPosition();
/*  80 */         Teleport.teleportToDimension(player, ModDimensions.MINING.getId(), playerPos.getX(), playerPos.getY(), playerPos.getZ());
/*  81 */         player.dimension = ModDimensions.MINING.getId();
/*     */       } else {
/*  83 */         BlockPos playerPos = player.getPosition();
/*  84 */         Teleport.teleportToDimension(player, DimensionType.OVERWORLD.getId(), playerPos.getX(), playerPos.getY(), playerPos.getZ());
/*  85 */         player.dimension = DimensionType.OVERWORLD.getId();
/*     */       } 
/*     */     }
/*     */     
/*  89 */     return super.processInteract(player, hand);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 103 */     super.onUpdate();
/* 104 */     if (this.isDead)
/* 105 */       return;  if (this.attack_delay > 0) this.attack_delay--; 
/* 106 */     if (this.attack_delay > 0)
/* 107 */       return;  this.attack_delay = 20;
/* 108 */     if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL)
/* 109 */       return;  if (OreSpawnMain.PlayNicely != 0)
/* 110 */       return;  EntityPlayer entityPlayer = this.world.getClosestPlayerToEntity((Entity)this, 1.5D);
/* 111 */     if (entityPlayer != null)
/* 112 */       attackEntityAsMob((Entity)entityPlayer); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.4-deobf.jar!\danger\orespawn\entity\RedAnt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */