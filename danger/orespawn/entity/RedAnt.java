/*     */ package danger.orespawn.entity;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.util.ai.MyEntityAIWanderALot;
/*     */ import net.minecraft.entity.Entity;
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
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RedAnt
/*     */   extends Ant
/*     */ {
/*  35 */   int attack_delay = 20;
/*     */ 
/*     */   
/*     */   public RedAnt(World par1World) {
/*  39 */     super(par1World);
/*     */     
/*  41 */     setSize(0.2F, 0.2F);
/*  42 */     this.moveSpeed = 0.20000000298023224D;
/*  43 */     this.experienceValue = 1;
/*     */     
/*  45 */     this.tasks.addTask(0, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.399999976158142D));
/*  46 */     this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0D, false));
/*  47 */     this.tasks.addTask(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0D));
/*  48 */     if (OreSpawnMain.PlayNicely == 0) this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, true));
/*     */   
/*     */   }
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
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attackEntityAsMob(Entity par1Entity) {
/*  69 */     if (OreSpawnMain.OreSpawnRand.nextInt(15) != 0) return false; 
/*  70 */     if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL) return false; 
/*  71 */     boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), 1.0F);
/*  72 */     return var4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/*  82 */     if (par1EntityPlayer == null) return false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  88 */     if (!(par1EntityPlayer instanceof net.minecraft.entity.player.EntityPlayerMP)) return false;
/*     */ 
/*     */     
/*  91 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*  92 */     if (var2 != null && 
/*  93 */       var2.getCount() <= 0) {
/*  94 */       par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*  95 */       var2 = null;
/*     */     } 
/*     */     
/*  98 */     if (var2 != null) {
/*  99 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     return true;
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
/* 124 */     super.onUpdate();
/* 125 */     if (this.isDead)
/* 126 */       return;  if (this.attack_delay > 0) this.attack_delay--; 
/* 127 */     if (this.attack_delay > 0)
/* 128 */       return;  this.attack_delay = 20;
/* 129 */     if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL)
/* 130 */       return;  if (OreSpawnMain.PlayNicely != 0)
/* 131 */       return;  EntityPlayer entityPlayer = this.world.getClosestPlayerToEntity((Entity)this, 1.5D);
/* 132 */     if (entityPlayer != null)
/* 133 */       attackEntityAsMob((Entity)entityPlayer); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.2-deobf.jar!\danger\orespawn\entity\RedAnt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */