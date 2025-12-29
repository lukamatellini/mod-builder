# Mod QA Test Plan: Lucky Block

**Mod ID:** `luckyblock`
**Minecraft Version:** 1.21.1
**Generated:** 2025-12-29T06:05:24.827Z
**Total Tests:** 13

## Quick Commands

Copy-paste these commands to quickly test features:

```
/give @p luckyblock:rotten_flesh
/give @p luckyblock:carrot
/give @p luckyblock:potato
/give @p luckyblock:randomly_drops_items_from_a_defined_loot_pool_or_spawns_a_hostile_zombie
/give @p luckyblock:refined_ingot
/summon luckyblock:lucky_zombie
```

## Items

### 🤖 Rotten Flesh Registration

**Command:** `/give @p luckyblock:rotten_flesh`

**Steps:**
1. Run: /give @p luckyblock:rotten_flesh
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Carrot Registration

**Command:** `/give @p luckyblock:carrot`

**Steps:**
1. Run: /give @p luckyblock:carrot
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Potato Registration

**Command:** `/give @p luckyblock:potato`

**Steps:**
1. Run: /give @p luckyblock:potato
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Randomly Drops Items From A Defined Loot Pool Or Spawns A Hostile Zombie Registration

**Command:** `/give @p luckyblock:randomly_drops_items_from_a_defined_loot_pool_or_spawns_a_hostile_zombie`

**Steps:**
1. Run: /give @p luckyblock:randomly_drops_items_from_a_defined_loot_pool_or_spawns_a_hostile_zombie
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Refined Ingot Registration

**Command:** `/give @p luckyblock:refined_ingot`

**Steps:**
1. Run: /give @p luckyblock:refined_ingot
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

## Recipes

### 👤 Rotten Flesh Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:stick","luckyblock:refined_ingot"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Rotten Flesh

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Carrot Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:stick","luckyblock:refined_ingot"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Carrot

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Potato Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:stick","luckyblock:refined_ingot"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Potato

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Randomly Drops Items From A Defined Loot Pool Or Spawns A Hostile Zombie Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:stick","luckyblock:refined_ingot"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Randomly Drops Items From A Defined Loot Pool Or Spawns A Hostile Zombie

- [ ] PASS
- [ ] FAIL: _________________

## Blocks

### 👤 Lucky Block Placement

**Command:** `/give @p luckyblock:lucky_block`

**Steps:**
1. Run: /give @p luckyblock:lucky_block
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

## Mobs

### 🤖 Lucky Zombie Spawn

**Command:** `/summon luckyblock:lucky_zombie`

**Steps:**
1. Run: /summon luckyblock:lucky_zombie
2. Verify mob spawns without crash
3. Check mob texture is not purple/black
4. Verify mob has expected health

**Expected:** Mob spawns with correct model and attributes

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Lucky Zombie AI Behavior

**Steps:**
1. Summon mob: /summon luckyblock:lucky_zombie
2. Approach mob (should be passive)
3. Observe movement patterns
4. Check mob responds to player presence

**Expected:** Mob ignores or flees from player

- [ ] PASS
- [ ] FAIL: _________________

## Mob Drops

### 👤 Lucky Zombie Loot

**Steps:**
1. Summon mob: /summon luckyblock:lucky_zombie
2. Kill the mob (use /kill if needed)
3. Collect dropped items
4. Verify drops match expected loot table

**Expected:** Drops: minecraft:rotten_flesh, minecraft:iron_ingot, minecraft:carrot, minecraft:potato

- [ ] PASS
- [ ] FAIL: _________________

## Test Summary

| Category | Tests | Passed | Failed |
|----------|-------|--------|--------|
| Items | 5 | [ ] | [ ] |
| Recipes | 4 | [ ] | [ ] |
| Blocks | 1 | [ ] | [ ] |
| Mobs | 2 | [ ] | [ ] |
| Mob Drops | 1 | [ ] | [ ] |

**Overall Result:** [ ] PASS / [ ] FAIL

**Notes:**

_Add any issues or observations here_