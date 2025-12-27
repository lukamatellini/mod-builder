# QA Test Plan: Thunderstrike Wand

Generated: 2025-12-27T13:18:45.238Z
Minecraft Version: 1.21.1
Mod ID: thunderstrikewand

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 24 |
| Passed | 18 |
| Failed | 0 |
| Warnings | 2 |
| Skipped | 4 |
| **Overall** | **WARN** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `thunderstrikewand.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Lightning Wand | `/give @p thunderstrikewand:lightning_wand` | ☐ | ☐ | ☐ |

### Item Tests

#### Lightning Wand

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lightning Wand"
- [ ] Crafting recipe works
- [ ] Right-click action works: projectile
- [ ] Cooldown applies (20 ticks)

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
